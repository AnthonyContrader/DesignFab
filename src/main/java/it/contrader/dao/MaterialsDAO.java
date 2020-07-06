package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Materials;

public class MaterialsDAO implements DAO<Materials>{

	private final String QUERY_ALL = "Select * from materials";
	private final String CREATE = "INSERT INTO materials(material_name, quantity_materials) VALUES (?, ?)";
	private final String READ = "Select * from materials where id= ?";
	private final String UPDATE = "UPDATE materials SET material_name= ?, quantity_materials = ? where id= ?";
	private final String DELETE = "DELETE from materials where id= ?";

	public MaterialsDAO() {

	}

	public List<Materials> getAll() {

		List<Materials> MaterialsList = new ArrayList<Materials>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Materials material;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String material_name = resultSet.getString("material_name");
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
			preparedStatement.setString(1, material.getMaterial_name());
			preparedStatement.setDouble(2, material.getQuantity());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public Materials read(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(READ);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String material_name = resultSet.getString("material_name");
			double quantity_materials = Double.parseDouble(resultSet.getString("quantity_materials"));
			Materials material = new Materials(material_name, quantity_materials);
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
		Materials materialRead = read(materialToUpdate.getId());
	
		if ((materialRead.getId()==materialToUpdate.getId() 
				&& !materialRead.equals(materialToUpdate.getMaterial_name()) 
				&& materialRead.getQuantity() == materialToUpdate.getQuantity())) {
			try {
				if (materialToUpdate.getMaterial_name() == null || materialToUpdate.getMaterial_name().equals("")) {
					materialToUpdate.setMaterial_name(materialRead.getMaterial_name());
				}
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
				preparedStatement.setString(1, materialToUpdate.getMaterial_name());
				preparedStatement.setDouble(2, materialToUpdate.getQuantity());
				preparedStatement.setInt(3, materialToUpdate.getId());
				int check = preparedStatement.executeUpdate();
				if (check > 0)
					return true;
				else
					return false;
			} catch (SQLException e) {
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
