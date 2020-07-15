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
import it.contrader.model.Machine;
import it.contrader.service.MaterialsService;

@Controller
@RequestMapping("/materials")
public class MaterialsController {

	@Autowired
	private MaterialsService service;

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "materials";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readmaterials";
	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("material_name") String materialName,
			@RequestParam("material_quantity") Double materialsQuantity/*,
			@RequestParam("machines") List<Machine> machines*/) {
		
		MaterialsDTO dto = new MaterialsDTO();
		
		dto.setMaterialName(materialName);
		dto.setMaterialsQuantity(materialsQuantity);
		//dto.setMachines(machines);
		return "materials";

	}
	
	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updatematerials";
	}
	
	@PostMapping("/update")
	public String update(HttpServletRequest request,@RequestParam("id_materials") Long idMaterials, @RequestParam("Material_name") String MaterialName,
			@RequestParam("Material_quantity") Double MaterialsQuantity/*,
			@RequestParam("machines") List<Machine> machines*/) {
		
		MaterialsDTO dto = new MaterialsDTO();
		
		dto.setIdMaterials(idMaterials);
		dto.setMaterialName(MaterialName);
		dto.setMaterialsQuantity(MaterialsQuantity);
		//dto.setMachinesOnMaterial(machines);
		return "materials";
	}
	
	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "materials";
	}

}
