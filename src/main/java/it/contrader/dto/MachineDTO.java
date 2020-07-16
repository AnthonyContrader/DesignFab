package it.contrader.dto;


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
