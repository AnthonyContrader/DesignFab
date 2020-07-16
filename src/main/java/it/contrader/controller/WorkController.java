package it.contrader.controller;

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
	
	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("machineList", machineService.getAll());
		request.getSession().setAttribute("materialsList", materialService.getAll());
	}
	
	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dtoWork", machineService.read(id));
		return "machine/readmachine";
	}
	
	@PostMapping("/update")
	public String insert(HttpServletRequest request, @RequestParam("material_quantity")
	Double MaterialsQuantity)
			 {
		
		MaterialsDTO dto = new MaterialsDTO();
		dto.setMaterialsQuantity(MaterialsQuantity);
		materialService.insert(dto);
		setAll(request);

		return "workresult";

	}
	
	
}
