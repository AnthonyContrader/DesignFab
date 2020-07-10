package it.contrader.service;

import it.contrader.converter.SensorConverter;
import it.contrader.dao.SensorDAO;
import it.contrader.dto.SensorDTO;
import it.contrader.model.Sensor;

public class SensorService extends AbstractService<Sensor, SensorDTO> {

	public SensorService() {
		this.dao = new SensorDAO();
		this.converter = new SensorConverter();
	}

	public SensorDTO getModelloMacchina(int id, int id_machine) {
		return converter.toDTOModel(dao.read(id), ((SensorDAO) dao).getModelloMacchina(id_machine));
	}
}
