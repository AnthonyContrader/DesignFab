package it.contrader.controller;

import it.contrader.dto.MaterialsDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.MachineService;
import it.contrader.service.MaterialsService;

public class LogicController implements Controller {

	private static String sub_package = "machine.";

	private MachineService machineService;
	private MaterialsService materialsService;

	public LogicController() {
		this.machineService = new MachineService();
	}

	@Override
	public void doControl(Request request) {

		String mode = (String) request.get("modeLogic");

		String choice = (String) request.get("choice");

		int id_machine;
		double final_quantity;
		int id_materials;
		String material_name;

		switch (mode) {

		case "CALCULATE":
			
			id_materials = Integer.parseInt(request.get("id").toString());
			material_name = request.get("material_name").toString();
			MaterialsDTO materialsUpdateDTO = new MaterialsDTO(material_name, id_materials);
			// materialsUpdateDTO.setId(id);
			materialsService.update(materialsUpdateDTO);
			request = new Request();
			request.put("modeLogic", "modeLogic");
			MainDispatcher.getInstance().callView(sub_package + "MachineLogic", request);
			break;
		}
	}
}
