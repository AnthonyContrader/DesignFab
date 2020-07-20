package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.converter.MachineConverter;
import it.contrader.converter.SensorConverter;
import it.contrader.dto.MachineDTO;
import it.contrader.dto.SensorDTO;
import it.contrader.model.Materials;
import it.contrader.service.MachineService;
import it.contrader.service.SensorService;

@Controller
@RequestMapping("/machine")
public class MachineController {

	@Autowired
	private MachineService machineService;
	@Autowired
	private SensorService sensorService;

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("machineList", machineService.getAll());
		request.getSession().setAttribute("sensorList", sensorService.getAll());
	}

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "machine/machines";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", machineService.read(id));
		return "machine/readmachine";
	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("machine_name") String machineName,
			@RequestParam("sensor_id") Long idSensorFk) {

		MachineDTO dto = new MachineDTO();
		SensorDTO sensdto = new SensorDTO();
		dto.setMachineName(machineName);
		sensdto = sensorService.read(idSensorFk);
		dto.setSensorDto(sensdto);
		machineService.insert(dto);
		setAll(request);
		return "machine/machines";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id,
			@RequestParam("id_sensor") Long idSensor) {
		request.getSession().setAttribute("dto", machineService.read(id));
		request.getSession().setAttribute("id_sensor", idSensor);
		return "machine/updatemachine";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long idMachine,
			@RequestParam("machine_name") String machineName, @RequestParam("id_sensor") Long idSensor) {

		MachineDTO dto = new MachineDTO();
		SensorDTO sensdto = sensorService.read(idSensor);
		dto.setSensorDto(sensdto);
		dto.setId_machine(idMachine);
		dto.setMachineName(machineName);

		machineService.update(dto);
		setAll(request);
		return "machine/machines";

	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		machineService.delete(id);
		setAll(request);
		return "machine/machines";
	}
}
