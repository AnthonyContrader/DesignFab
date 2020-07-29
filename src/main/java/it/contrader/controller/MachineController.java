package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.converter.MachineConverter;
import it.contrader.converter.SensorConverter;
import it.contrader.dto.MachineDTO;
import it.contrader.dto.MachineSensorDTO;
import it.contrader.dto.MaterialsDTO;
import it.contrader.dto.SensorDTO;
import it.contrader.dto.SensorMaterialDTO;
import it.contrader.model.Materials;
import it.contrader.service.MachineService;
import it.contrader.service.MaterialsService;
import it.contrader.service.SensorService;

@RestController
@RequestMapping("/machines")
@CrossOrigin(origins = "http://localhost:4200")
public class MachineController  extends AbstractController<MachineDTO>{
	@Autowired
	private SensorService sensorService;
	@Autowired
	private MachineService machineService;
	
	
	
	
	@PostMapping(value ="/insert2") 
		public MachineDTO insert2( @RequestBody MachineSensorDTO machineSensorDTO ){
            System.out.println(machineSensorDTO.getIdSensor()+" "+ machineSensorDTO.getMachine_name());
			SensorDTO sensorDto = new SensorDTO();
			MachineDTO machineDto = new MachineDTO();

			sensorDto = sensorService.read(machineSensorDTO.getIdSensor());
			machineDto.setMachineName(machineSensorDTO.getMachine_name());
			machineDto.setSensorDto(sensorDto);		
			machineService.insert(machineDto);
			return machineDto;
	}

}
