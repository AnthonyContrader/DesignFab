package it.contrader.controller;

import java.util.List;
import it.contrader.dto.MaterialsDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.MaterialsService;

public class MaterialsController implements Controller {

	private static String sub_package = "materials.";
	private MaterialsService materialsService;

	public MaterialsController() {

		this.materialsService = new MaterialsService();
	}

	@Override
	public void doControl(Request request) {

		String mode = (String) request.get("modeMaterials");
		String choice = (String) request.get("choice");

		int id;
		String material_name;
try {
		switch (mode) {

		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			MaterialsDTO materialsDTO = materialsService.read(id);
			request.put("materials", materialsDTO);
			MainDispatcher.getInstance().callView(sub_package + "MaterialsRead", request);
			break;

		case "INSERT":

			material_name = request.get("material_name").toString();
			System.out.println(material_name);
			MaterialsDTO materialsToInsertDTO = new MaterialsDTO(material_name);
			materialsService.insert(materialsToInsertDTO);
			request = new Request();
			request.put("modeMaterials", "modeMaterials");
			MainDispatcher.getInstance().callView(sub_package + "MaterialsInsert", request);
			break;

		case "DELETE":

			id = Integer.parseInt(request.get("id").toString());
			materialsService.delete(id);
			request = new Request();
			request.put("modeMaterials", "modeMaterials");
			MainDispatcher.getInstance().callView(sub_package + "MaterialsDelete", request);
			break;

		case "UPDATE":

			id = Integer.parseInt(request.get("id").toString());
			material_name = request.get("material_name").toString();
			MaterialsDTO materialsUpdateDTO = new MaterialsDTO(material_name, id);
			// materialsUpdateDTO.setId(id);
			materialsService.update(materialsUpdateDTO);
			request = new Request();
			request.put("modeMaterials", "modeMaterials");
			MainDispatcher.getInstance().callView(sub_package + "MaterialsUpdate", request);
			break;

		case "MATERIALSLIST":
			List<MaterialsDTO> materialDTO = materialsService.getAll();
			request.put("materials", materialDTO);
			MainDispatcher.getInstance().callView("Materials", request);
			break;

		case "GETCHOICE":
			switch (choice.toUpperCase()) {

			case "L":
				MainDispatcher.getInstance().callView(sub_package + "MaterialsRead", null);
				break;

			case "I":
				MainDispatcher.getInstance().callView(sub_package + "MaterialsInsert", null);
				break;

			case "M":
				MainDispatcher.getInstance().callView(sub_package + "MaterialsUpdate", null);
				break;

			case "C":
				MainDispatcher.getInstance().callView(sub_package + "MaterialsDelete", null);
				break;

			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;

			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;

			default:
				MainDispatcher.getInstance().callView("Login", null);
			}

		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
}catch(NullPointerException e) {
	e.printStackTrace();
}

	}
}
