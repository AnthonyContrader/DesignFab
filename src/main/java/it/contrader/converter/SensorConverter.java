package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.MaterialsDTO;
import it.contrader.dto.SensorDTO;
import it.contrader.model.Machine;
import it.contrader.model.Materials;
import it.contrader.model.Sensor;

@Component
public class SensorConverter extends AbstractConverter<Sensor, SensorDTO> {

	@Autowired
	MaterialsConverter materialsConverter;
	
	@Override
	public Sensor toEntity(SensorDTO sensordto) {
		Sensor sensor = null;
		if (sensordto != null) 
			sensor = new Sensor(sensordto.getId_sensor(), sensordto.getSensor_name(), new Machine(), materialsConverter.toEntity(sensordto.getMaterialsDTO()));

		return sensor;
	}

	@Override
	public SensorDTO toDTO(Sensor sensor) {
		SensorDTO sensordto = null;
		if (sensor != null) {
			if(sensor.getMaterials() != null)
				sensordto = new SensorDTO(sensor.getId_sensor(), sensor.getName_sensor(), materialsConverter.toDTO(sensor.getMaterials()));
			else {
				sensordto = new SensorDTO(sensor.getId_sensor(), sensor.getName_sensor(), new MaterialsDTO());
			}
		}
			
		return sensordto;
	}

}
