package it.contrader.dto;

import java.util.List;

import it.contrader.model.Machine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SensorDTO {

	private Long id_sensor;

	private String sensor_name;

	private List<Machine> id_machine;

	private String machine_name;

}
