package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.SensorConverter;
import it.contrader.dao.SensorDAO;
import it.contrader.dto.SensorDTO;
import it.contrader.model.Sensor;

@Service
public class SensorService extends AbstractService<Sensor, SensorDTO> {

	@Autowired
	private SensorConverter sensorConverter;
	@Autowired
	private SensorDAO sensorDao;

	/*public String getModelMachine() {
		return sensorConverter.toDTO(sensorDao.getModelMachine());

	}*/

}
