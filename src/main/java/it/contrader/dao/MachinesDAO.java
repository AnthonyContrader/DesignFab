package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Machines;

public class MachinesDAO implements DAO<Machines>{
	private final String QUERY_ALL = "SELECT * FROM machine";
	private final String CREATE = "INSERT INTO machine(model, init_quantity,final_quantity) VALUES (?,?,?)";
	private final String READ = "SELECT * FROM machine where id=?";
	private final String UPDATE = "UPDATE machine SET model=?, init_quantity=?, final_quantity=? WHERE id=?";
	private final String UPDATE_QUANTITY = "UPDATE machine SET init_quantity=?, final_quantity=? WHERE id=?";
	private final String DELETE = "DELETE FROM machine WHERE id=?";

	public MachinesDAO() {

	}

	public List<Machines> getAll() {
		List<Machines> MachineList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Machines machine;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String model = resultSet.getString("model");
				Double init_quantity = resultSet.getDouble("init_quantity");
				Double final_quantity = resultSet.getDouble("final_quantity");
				machine = new Machines(model, init_quantity, final_quantity);
				machine.setId(id);
				MachineList.add(machine);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return MachineList;

	}

	public boolean insert(Machines machineToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(CREATE);
			preparedStatement.setString(1, machineToInsert.getModel());
			preparedStatement.setDouble(2, machineToInsert.getInit_quantity());
			preparedStatement.setDouble(3, machineToInsert.getFinal_quantity());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Machines read(int machineId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {

			PreparedStatement preparedStatement = connection.prepareStatement(READ);
			preparedStatement.setInt(1, machineId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String model;
			double init_quantity, final_quantity;

			model = resultSet.getString("model");
			init_quantity = resultSet.getDouble("init_quantity");
			final_quantity = resultSet.getDouble("final_quantity");
			Machines machine = new Machines(model, init_quantity, final_quantity);
			machine.setId(resultSet.getInt("id"));

			return machine;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Machines machineToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		if (machineToUpdate.getId() == 0)
			return false;

		Machines machineRead = read(machineToUpdate.getId());
		if (!machineRead.equals(machineToUpdate)) {
			try {
				if (machineToUpdate.getModel() == null || machineToUpdate.getModel().equals("")) {
					machineToUpdate.setModel(machineRead.getModel());
				}

				if (machineToUpdate.getInit_quantity() < 0) {
					machineToUpdate.setInit_quantity(machineRead.getInit_quantity());
				}

				if (machineToUpdate.getFinal_quantity() < 0) {
					machineToUpdate.setFinal_quantity(machineRead.getFinal_quantity());
				}

				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(UPDATE);
				preparedStatement.setString(1, machineToUpdate.getModel());
				preparedStatement.setDouble(2, machineToUpdate.getInit_quantity());
				preparedStatement.setDouble(3, machineToUpdate.getFinal_quantity());
				preparedStatement.setInt(4, machineToUpdate.getId());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
		}

		return false;

	}
	public boolean updateQuantity(Machines machineToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		if (machineToUpdate.getId() == 0)
			return false;

		Machines machineRead = read(machineToUpdate.getId());
		//if (!machineRead.equals(machineToUpdate)) {
			try {
			//	if (machineToUpdate.getModel() == null || machineToUpdate.getModel().equals("")) {
			//		machineToUpdate.setModel(machineRead.getModel());
			//	}

				if (machineToUpdate.getInit_quantity() < 0) {
					machineToUpdate.setInit_quantity(machineRead.getInit_quantity());
				}

				if (machineToUpdate.getFinal_quantity() < 0) {
					machineToUpdate.setFinal_quantity(machineRead.getFinal_quantity());
				}

				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(UPDATE_QUANTITY);
				preparedStatement.setDouble(1, machineToUpdate.getInit_quantity());
				preparedStatement.setDouble(2, machineToUpdate.getFinal_quantity());
				preparedStatement.setInt(3, machineToUpdate.getId());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
		//}

	//	return false;

	}

	public boolean delete(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}

}
