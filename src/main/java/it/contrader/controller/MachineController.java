package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.MachineDTO;
import it.contrader.model.Materials;
import it.contrader.service.MachineService;

@Controller
@RequestMapping("/machine")
public class MachineController {

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
			@RequestParam("material_name") String materialName, @RequestParam("materials") List<Materials> materials) {
		
		MachineDTO dto = new MachineDTO();
		
		dto.setMachineName(machineName);
		dto.setMaterialName(materialName);
		dto.setMaterials(materials);
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
			@RequestParam("material_name") String materialName,
			@RequestParam("materials") List<Materials> materials) {

		MachineDTO dto = new MachineDTO();

		dto.setId_machine(idMachine);
		dto.setMachineName(machineName);
		dto.setMaterialName(materialName);
		dto.setMaterials(materials);
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
