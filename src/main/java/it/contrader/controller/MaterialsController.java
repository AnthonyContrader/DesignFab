package it.contrader.controller;

import java.util.List;

import it.contrader.dto.MaterialsDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.MaterialsService;

public class MaterialsController implements Controller{
	
	private MaterialsService materialsService;
	private static String sub_package = "materials.";
	
	public MaterialsController() {
		
		this.materialsService = new MaterialsService();
	}

	@Override
	public void doControl(Request request) {
		String modeMaterials = (String) request.get("mode");
		String choiceMaterials = (String) request.get("choice");
		
		int id;
		String material_name;
		
		
		switch (modeMaterials) {
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			MaterialsDTO materialsDTO = materialsService.read(id);
			request.put("materials", materialsDTO);
			MainDispatcher.getInstance().callView(sub_package + "MaterialsRead", request);
			break;
		case "INSERT":
			material_name = request.get("material_name").toString();
			MaterialsDTO materialsToInsertDTO = new MaterialsDTO(material_name);
			materialsService.insert(materialsToInsertDTO);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "SensorInsert", request);
			break;
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			materialsService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "SensorDelete", request);
			break;
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			material_name = request.get("sensor_type").toString();
			MaterialsDTO sensorUpdateDTO = new MaterialsDTO(material_name);
			sensorUpdateDTO.setId(id); // ???????
			materialsService.update(sensorUpdateDTO);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "SensorUpdate", request);
			break;
		case "SENSORLIST":
			List<MaterialsDTO> sensorsDTO = materialsService.getAll();
			request.put("sensors", sensorsDTO);
			MainDispatcher.getInstance().callView(sub_package + "Sensor", request);
			break;
			
		case "GETCHOICE":
			
			//toUpperCase() mette in maiuscolo la scelta
	switch (choiceMaterials.toUpperCase()) {
	
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
	}
}
	
