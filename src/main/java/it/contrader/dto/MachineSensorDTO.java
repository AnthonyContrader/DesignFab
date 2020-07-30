package it.contrader.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
	
public class MachineSensorDTO {
	
	private String machine_name;
	private int idSensor;
	private int idMachine;
	
}
