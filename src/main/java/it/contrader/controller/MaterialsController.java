package it.contrader.controller;

import org.hibernate.type.MaterializedNClobType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import it.contrader.dto.MaterialsDTO;
import it.contrader.model.Materials.Materialtype;
import it.contrader.service.MaterialsService;

@Controller
@RequestMapping("/materials")
@CrossOrigin(origins = "http://localhost:4200")
public class MaterialsController extends AbstractController<MaterialsDTO> {

	@Autowired
	MaterialsService materialService;
	
	@PostMapping(value="/materials")
	public MaterialsDTO updateMaterial(@RequestBody Materialtype type) {
		return materialService.findByMaterialType(type);

	}

}
