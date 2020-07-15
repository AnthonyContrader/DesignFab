package it.contrader.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.converter.MachineConverter;
import it.contrader.converter.MaterialsConverter;
import it.contrader.converter.SensorConverter;
import it.contrader.dao.MachineRepository;
import it.contrader.dao.SensorDAO;
import it.contrader.dto.MachineDTO;
import it.contrader.dto.MaterialsDTO;
import it.contrader.dto.SensorDTO;
import it.contrader.model.Materials;
import it.contrader.model.Sensor;
import it.contrader.service.MachineService;

@Controller
@RequestMapping("/machine")
public class MachineController {

	/*@Autowired
	MachineRepository repository;
	@Autowired
	SensorDAO sensorRepository;*/
	@Autowired
	private MachineService service;

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "machines";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readmachine";
	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("machine_name") String machineName,
			@RequestParam("material_name") String materialName, @RequestParam("id_sensor") Long id_sensor) {
		
		//MachineDTO machineDTO = new MachineDTO(0L, "prova","prova",sensorRepository.findById(1L).get()/*, new ArrayList<>()*/);
		//MaterialsDTO materialsDTO = new MaterialsDTO(0L , "glass" , 100.0 , new ArrayList<>());
		//MachineConverter converterMachine = new MachineConverter();
		//MaterialsConverter converterMaterials = new MaterialsConverter();
	    //machineDTO.getMaterialsOnMachine().add(converterMaterials.toEntity(materialsDTO));
		//materialsDTO.getMachinesOnMaterial().add(converterMachine.toEntity(machineDTO));
		
		//repository.save(converterMachine.toEntity(machineDTO));
		
		MachineDTO dto = new MachineDTO();
		SensorConverter sensorConverter = new SensorConverter();
		SensorDTO sensorDTO = new SensorDTO();
		sensorDTO.setId_sensor(id_sensor);
		dto.setMachineName(machineName);
		dto.setMaterialName(materialName);
		dto.setSensor(sensorConverter.toEntity(sensorDTO));
		service.insert(dto);
		setAll(request); 
		return "machines";
	}
	
	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updatemachine";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id_machine") long idMachine,
			@RequestParam("machine_name") String machineName,
			@RequestParam("material_name") String materialName/*,
			@RequestParam("materials") List<Materials> materials*/) {

		MachineDTO dto = new MachineDTO();

		dto.setId_machine(idMachine);
		dto.setMachineName(machineName);
		dto.setMaterialName(materialName);
		//dto.setMaterialsOnMachine(materials);
		service.insert(dto);
		setAll(request);
		return "machines";

	}
	
	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "machines";
	}
}
