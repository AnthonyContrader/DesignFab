package it.contrader.dto;

import java.util.List;

import it.contrader.model.Materials;
import it.contrader.model.Sensor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MachineDTO {

	private Long id_machine;

	private String machineName;

	private SensorDTO sensorDto;
	
	
}
