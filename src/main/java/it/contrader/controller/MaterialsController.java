package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.MaterialsDTO;
import it.contrader.dto.SensorDTO;
import it.contrader.model.Machine;
import it.contrader.service.MaterialsService;
import it.contrader.service.SensorService;

@Controller
@RequestMapping("/materials")
public class MaterialsController {

	@Autowired
	private MaterialsService service;
	@Autowired
	private SensorService serviceSensor;

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "materials/materials";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "materials/materialsRead";
	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("material_name") String MaterialName,
			@RequestParam("material_quantity") Double MaterialsQuantity)
			 {
		
		MaterialsDTO dto = new MaterialsDTO();
		dto.setMaterialName(MaterialName);
		dto.setMaterialsQuantity(MaterialsQuantity);
		service.insert(dto);
		setAll(request);

		return "materials/materials";

	}
	
	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "materials/materialsUpdate";
	}
	
	@PostMapping("/update")
	public String update(HttpServletRequest request,@RequestParam("id") Long idMaterials, @RequestParam("materials_name") String MaterialName,
			@RequestParam("material_quantity") Double MaterialsQuantity) {
		
		MaterialsDTO dto = new MaterialsDTO();
		
		dto.setIdMaterials(idMaterials);
		dto.setMaterialName(MaterialName);
		dto.setMaterialsQuantity(MaterialsQuantity);
		service.update(dto);
		setAll(request);
		return "materials/materials";
	}
	
	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "materials/materials";
	}

}
