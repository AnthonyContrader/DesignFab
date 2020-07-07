package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Sensor;

public class SensorDAO implements DAO<Sensor>{

	private final String QUERY_ALL = "Select * from sensor";
	private final String CREATE = "insert into sensor (sensor_type, id_machine) values (?,?)";
	private final String READ = "Select * from sensor where id=?";
	private final String UPDATE = "UPDATE sensor SET sensor_type=? where id=?";
	private final String DELETE = "DELETE from sensor where id=?";
	private final String MACHINE_SENSOR_READ = "SELECT model from machine, sensor where machine.id = sensor.id_machine";
	public SensorDAO() {
	}



	public List<Sensor> getAll() {

		List<Sensor> sensorList = new ArrayList<Sensor>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Sensor sensor;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				int id_machine = resultSet.getInt("id_machine");
				String sensor_type = resultSet.getString("sensor_type");
				sensor = new Sensor(sensor_type, id_machine);
				sensor.setId(id);
				sensorList.add(sensor);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return sensorList;

	}

	public boolean insert(Sensor sensor) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(CREATE);
			preparedStatement.setString(1, sensor.getSensor_type());
			preparedStatement.setInt(2, sensor.getId_machine());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public Sensor read(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(READ);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String sensor_type;
			int id_machine;
			sensor_type = resultSet.getString("sensor_type");
			id_machine = resultSet.getInt("id_machine");
			Sensor sensor = new Sensor(sensor_type, id_machine);
			sensor.setId(resultSet.getInt(id));
			return sensor;
		} catch (SQLException e) {
			// e.printStackTrace();
			return null;
		}
	}

	public boolean update(Sensor sensorToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
		if (sensorToUpdate.getId() == 0)
			return false;

		Sensor sensor = read(sensorToUpdate.getId());
		if (!sensor.equals(sensorToUpdate)) {

			if (sensorToUpdate.getSensor_type() == null || sensorToUpdate.getSensor_type().equals("")) {
				sensorToUpdate.setSensor_type(sensor.getSensor_type());
			}

			try {
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(UPDATE);
				preparedStatement.setInt(2, sensorToUpdate.getId());
				preparedStatement.setString(1, sensorToUpdate.getSensor_type());

				int check = preparedStatement.executeUpdate();
				if (check > 0)
					return true;
				return false;
			} catch (SQLException e) {

				e.printStackTrace();
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
