package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.MaterialsDTO;
import it.contrader.service.MaterialsService;

@Controller
@RequestMapping("/glass")
public class GlassController {
	@Autowired
	private MaterialsService materialService;

	@PostMapping("/updateGlass")
	public String update(HttpServletRequest request, @RequestParam("material_glass") double quantit_materials,
			@RequestParam("id_material") Long id_material) {

		MaterialsDTO materialsDto = materialService.read(id_material);
		System.out.println("quantità " + quantit_materials);
		// double materialsQuantity = Math.random() * (quantit_materials - 0.0) + 0;
		materialsDto.setMaterialsQuantity(quantit_materials);
		materialsDto.setIdMaterials(id_material);
		materialService.update(materialsDto);
		request.getSession().setAttribute("glassquantity", quantit_materials);
		return "glassResult";

	}
}
