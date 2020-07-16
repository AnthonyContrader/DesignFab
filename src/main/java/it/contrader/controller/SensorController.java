package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.MaterialsDTO;
import it.contrader.dto.SensorDTO;
import it.contrader.service.MaterialsService;
import it.contrader.service.SensorService;

@Controller
@RequestMapping("/sensor")
public class SensorController {

	@Autowired
	private SensorService sensorService;
	@Autowired
	private MaterialsService materialsService;

	private void setAll(HttpServletRequest request) {
		
		request.getSession().setAttribute("listSensor", sensorService.getAll());
		request.getSession().setAttribute("listMaterials", materialsService.getAll());
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
	public String insert(HttpServletRequest request, @RequestParam("sensor_name") String sensor_name,
			@RequestParam("id_material") Long idMaterialFK) {

		SensorDTO sensorDto = new SensorDTO();
		MaterialsDTO materialsDTO = new MaterialsDTO();

		materialsDTO = materialsService.read(idMaterialFK);
		sensorDto.setSensor_name(sensor_name);
		sensorDto.setMaterialsDTO(materialsDTO);		
		sensorService.insert(sensorDto);
		setAll(request);
		return "sensor/sensors";

	}

	@GetMapping("/preupdate")
	public String preupdate(HttpServletRequest request, @RequestParam("id") Long id,
			@RequestParam("id_material") Long idMaterialFK) {
		request.getSession().setAttribute("dto", sensorService.read(id));
		request.getSession().setAttribute("id_material", sensorService.read(id));
		return "sensor/sensorUpdate";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id_sensor,
			@RequestParam("sensor_name") String sensor_name, @RequestParam("id_material") Long idMaterialFK) {

		SensorDTO sensorDto = new SensorDTO();
		MaterialsDTO materialsDTO = new MaterialsDTO();

		materialsDTO = materialsService.read(idMaterialFK);
		sensorDto.setMaterialsDTO(materialsDTO);
		sensorDto.setSensor_name(sensor_name);
		sensorService.update(sensorDto);
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
