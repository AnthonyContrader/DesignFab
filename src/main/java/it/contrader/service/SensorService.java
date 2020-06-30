package it.contrader.service;

import java.util.List;

import it.contrader.converter.SensorConverter;
import it.contrader.dao.SensorDAO;
import it.contrader.dto.SensorDTO;




public class SensorService {
	
	private SensorDAO sensorDAO;
	private SensorConverter sensorConverter;
	
	public SensorService(){
		this.sensorDAO = new SensorDAO();
		this.sensorConverter = new SensorConverter();
	}
	

	public List<SensorDTO> getAll() {
		return sensorConverter.toDTOList(sensorDAO.getAllSensor());
	}


	public SensorDTO read(int id) {
		return sensorConverter.toDTO(sensorDAO.getSensorRead(id));
	}


	public boolean insert(SensorDTO dto) {
		return sensorDAO.insert(sensorConverter.toEntity(dto));
	}


	public boolean update(SensorDTO dto) {
		return sensorDAO.update(sensorConverter.toEntity(dto));
	}


	public boolean delete(int id) {
		return sensorDAO.delete(id);
	}
	
}
