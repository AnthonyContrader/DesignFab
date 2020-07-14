package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.SensorDTO;
import it.contrader.model.Sensor;

@Component
public class SensorConverter extends AbstractConverter<Sensor, SensorDTO>{

	@Override
	public Sensor toEntity(SensorDTO sensordto) {
		Sensor sensor = null;
		if (sensordto != null)
			sensor= new Sensor(sensordto.getId_sensor(), sensordto.getSensor_name(), sensordto.getId_machine());
		return sensor;
	}

	@Override
	public SensorDTO toDTO(Sensor sensor) {
		SensorDTO sensordto = null;
		if (sensor != null)
			sensordto= new SensorDTO(sensor.getId_sensor(), sensor.getName_sensor(), sensor.getId_machine());
		return sensordto;
	}

	
}
