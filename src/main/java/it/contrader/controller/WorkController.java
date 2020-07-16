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
import it.contrader.service.MachineService;
import it.contrader.service.MaterialsService;

@Controller
@RequestMapping("/work")
public class WorkController {
	
	@Autowired
	private MaterialsService materialService;
	@Autowired
	private MachineService machineService;
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "homeuser";
	}
	
	private void setAll(HttpServletRequest request) {
		
		request.getSession().setAttribute("materialsList", materialService.getAll());
	}
	
	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dtoWork", machineService.read(id));
		return "homeuser";
	}
	
	@PostMapping("/update")
	public String insert(HttpServletRequest request, @RequestParam("material_quantity")
	Double MaterialsQuantity)
			 {
		List<MaterialsDTO> list=  materialService.getAll();
		Long id_materialsGenerico= null;
		String material_name= "GENERIC";
		for(MaterialsDTO u : list) {
		if (u.getMaterialName().equals("GENERIC")){
		id_materialsGenerico = u.getIdMaterials();} }	
		MaterialsDTO dto = new MaterialsDTO();
		dto.setIdMaterials(id_materialsGenerico);
		dto.setMaterialsQuantity(MaterialsQuantity);
		dto.setMaterialName(material_name);
		materialService.update(dto);
		setAll(request);
		return "homeuser";

	}
	
	
}
