package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.MaterialsDTO;
import it.contrader.dto.SensorDTO;
import it.contrader.dto.SensorMaterialDTO;
import it.contrader.service.MaterialsService;
import it.contrader.service.SensorService;


@RestController
@RequestMapping("/sensor")
@CrossOrigin(origins = "http://localhost:4200")
public class SensorController extends AbstractController<SensorDTO>{
	@Autowired
	private SensorService sensorService;
	@Autowired
	private MaterialsService materialsService;
	@PostMapping(value ="/insert2") 
		public SensorDTO insert2( @RequestBody SensorMaterialDTO sensormaterialDTO ){
            System.out.println(sensormaterialDTO.getIdMaterial()+" "+ sensormaterialDTO.getSensor_name());
			SensorDTO sensorDto = new SensorDTO();
			MaterialsDTO materialsDTO = new MaterialsDTO();

			materialsDTO = materialsService.read(sensormaterialDTO.getIdMaterial());
			sensorDto.setSensor_name(sensormaterialDTO.getSensor_name());
			sensorDto.setMaterialsDTO(materialsDTO);		
			sensorService.insert(sensorDto);
			return sensorDto;
	}
}
