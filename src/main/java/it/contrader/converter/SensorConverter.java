package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.SensorDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Sensor;
import it.contrader.model.User;

public class SensorConverter {

	public SensorConverter() {

	}

	public SensorDTO toDTO(Sensor sensor) {

		SensorDTO sensorDTO = new SensorDTO(sensor.getId(), sensor.getSensor_type());
		return sensorDTO;

	}

	public Sensor toEntity(SensorDTO sensorDTO) {

		Sensor sensor = new Sensor(sensorDTO.getId(), sensorDTO.getSensortype());
		return sensor;

	}

	public List<SensorDTO> toDTOList(List<Sensor> sensorList) {
		// Crea una lista vuota.
		List<SensorDTO> sensorDTOList = new ArrayList<SensorDTO>();

		// Cicla tutti gli elementi della lista e li converte uno a uno
		for (Sensor sensor : sensorList) {
			// Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			// e lo aggiunge adda lista di DTO
			sensorDTOList.add(toDTO(sensor));
		}
		return sensorDTOList;
	}

}
