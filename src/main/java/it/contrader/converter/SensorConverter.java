package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;
import it.contrader.dto.SensorDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Sensor;
import it.contrader.model.User;

public class SensorConverter implements Converter<Sensor, SensorDTO> {

	public SensorConverter() {

	}
	
	

	@Override
	public SensorDTO toDTO(Sensor entity) {
		SensorDTO sensorDTO = new SensorDTO(entity.getId(), entity.getSensor_type(), entity.getId_machine());
		return sensorDTO;
	}

	@Override
	public Sensor toEntity(SensorDTO dto) {
		Sensor sensor = new Sensor(dto.getSensortype(), dto.getId_machine());
		sensor.setId(dto.getId());
		return sensor;
	}

	@Override
	public List<SensorDTO> toDTOList(List<Sensor> entityList) {

		List<SensorDTO> sensorDTOList = new ArrayList<SensorDTO>();
		
		for (Sensor sensor : entityList) {
			sensorDTOList.add(toDTO(sensor));
		}
		return sensorDTOList;
	}



	@Override
	public SensorDTO toDTOModel(Sensor entity,String modelloMacchina) {
		SensorDTO sensordto= new SensorDTO(entity.getSensor_type(), modelloMacchina );
		sensordto.setId(entity.getId());
		return sensordto ;
	}

}
