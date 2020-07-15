package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.SensorDTO;
import it.contrader.model.Machine;
import it.contrader.service.SensorService;

@Controller
@RequestMapping("/sensor")
public class SensorController {

	@Autowired
	private SensorService sensorService;

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("listSensor", sensorService.getAll());
	}

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "sensor/sensors";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("readSensor", sensorService.read(id));
		return "sensor/sensorRead";
	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("sensor_name") String sensor_name) {
		// passare il machine_name nel dto
		SensorDTO sensorDto = new SensorDTO();
		
		sensorDto.setSensor_name(sensor_name);
		sensorService.insert(sensorDto);
		setAll(request);
		return "sensor/sensors";

	}

	@GetMapping("/preupdate")
	public String preupdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto",  sensorService.read(id));
		return "sensor/sensorUpdate";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id_sensor,
			@RequestParam("sensor_name") String name_sensor) {

		SensorDTO sensorDTO = new SensorDTO();
		sensorDTO.setId_sensor(id_sensor);
		sensorDTO.setSensor_name(name_sensor);
		sensorService.update(sensorDTO);
		setAll(request);
		return "sensor/sensors";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		sensorService.delete(id);
		setAll(request);
		return "sensor/sensors";
	}
	
}
