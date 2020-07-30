package it.contrader.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.LoginDTO;
import it.contrader.dto.MaterialsDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Materials.Materialtype;
import it.contrader.service.MaterialsService;

@RestController
@RequestMapping("/materials")
@CrossOrigin(origins = "http://localhost:4200")
public class MaterialsController extends AbstractController<MaterialsDTO> {

	MaterialsService materialService;
	@GetMapping("/getallby/{materialType}")
	public List<MaterialsDTO> findAllType(@PathVariable("materialType") String materialType) {
		Materialtype type = Materialtype.valueOf(materialType);

		return ((MaterialsService) this.service).findAllByMaterialType(type);

	}
	

	@GetMapping(value = "/calcola/{genericQuantity}")
	public List<MaterialsDTO> calcola(@PathVariable("genericQuantity") double genericQuantity) {
		
		
		return ((MaterialsService) this.service).calcolaService(genericQuantity);


	
	}	
}
// con questa chiamata rest possiamo farci una lista di materiali in base al
// tipo, però in questo caso con il path dinamico in base a come è composto
// il path otteniamo il tipo attravero la url