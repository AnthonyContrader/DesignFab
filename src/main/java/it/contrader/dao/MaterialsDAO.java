package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Materials;


public class MaterialsDAO {
	
	private final String QUERY_ALL = "Select * from materials";
	private final String CREATE = "INSERT INTO materials(material_name) VALUES (?)";
	private final String READ = "Select * from materials where id= ?";
	private final String UPDATE = "UPDATE material SET material_name= ? where id= ?";
	private final String DELETE = "DELETE from materials where id= ?";
	
	public MaterialsDAO() {
	
	}
	public List<Materials> getAllMaterials() {

		List<Materials> MaterialsList = new ArrayList<Materials>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Materials material;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String material_name= resultSet.getString("material_name");
				material = new Materials(material_name);
				material.setId(id);
				MaterialsList.add(material);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return MaterialsList;
	}
	
		public boolean insert(Materials material) {
			Connection connection = ConnectionSingleton.getInstance();
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(CREATE);
				preparedStatement.setString(1, material.getName());
				preparedStatement.execute();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;

		}
		
		public Materials getMaterialRead(int id) {
			Connection connection = ConnectionSingleton.getInstance();
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(READ);
				preparedStatement.setInt(1, id);
				ResultSet resultSet = preparedStatement.executeQuery();
				resultSet.next();
				String material_name= resultSet.getString("material_name");
				Materials material = new Materials(material_name);
				material.setId(resultSet.getInt(id));
				return material;
			} catch (SQLException e) {
				// e.printStackTrace();
				return null;
			}
		}
		
		public boolean update(Materials materialToUpdate) {
			Connection connection = ConnectionSingleton.getInstance();
			if (materialToUpdate.getId() == 0)
				return false;

			Materials materialRead = getMaterialRead(materialToUpdate.getId());
			if (!materialRead.equals(materialToUpdate)) {
			  try {
				if (materialToUpdate.getName() == null || materialToUpdate.getName().equals("")) {
					materialToUpdate.setName(materialRead.getName());
				}
					PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
					preparedStatement.setString(1, materialToUpdate.getName());
					preparedStatement.setInt(2, materialToUpdate.getId());
					int check = preparedStatement.executeUpdate();
					if (check > 0)
						return true;
					else
						return false;
				} catch (SQLException e)  {
					e.printStackTrace();
					return false;
				}
			}
			return false;
		}

		public boolean delete(int id) {
			Connection connection = ConnectionSingleton.getInstance();
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
				preparedStatement.setInt(1, id);

				int check = preparedStatement.executeUpdate();
				if (check != 0)
					return true;

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;

		}

}
