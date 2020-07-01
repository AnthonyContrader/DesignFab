package it.contrader.controller;

import java.util.List;
import it.contrader.dto.SensorDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.SensorService;

public class SensorController implements Controller {

	private SensorService sensorService;
	private static String sub_package = "sensor.";

	public SensorController() {
		
		this.sensorService = new SensorService();
	}

	@Override
	public void doControl(Request request) {
		String modeSensor = (String) request.get("mode");
		String choiceSensor = (String) request.get("choice");

		int id;
		//int id_machines;
		
		String sensorType;

		switch (modeSensor) {
		
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			SensorDTO sensorDTO = sensorService.read(id);
			request.put("sensor", sensorDTO);
			MainDispatcher.getInstance().callView(sub_package + "SensorRead", request);
			break;
			
		case "INSERT":
			sensorType = request.get("sensor_type").toString();
			SensorDTO sensorToInsertDTO = new SensorDTO(sensorType);
			sensorService.insert(sensorToInsertDTO);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "SensorInsert", request);
			break;
			
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			sensorService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "SensorDelete", request);
			break;
			
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			sensorType = request.get("sensor_type").toString();
			SensorDTO sensorUpdateDTO = new SensorDTO(sensorType);
			sensorUpdateDTO.setId(id); // ???????
			sensorService.update(sensorUpdateDTO);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "SensorUpdate", request);
			break;
			
		case "SENSORLIST":
			List<SensorDTO> sensorsDTO = sensorService.getAll();
			request.put("sensors", sensorsDTO);
			MainDispatcher.getInstance().callView(sub_package + "Sensor", request);
			break;
		
		
		case "GETCHOICE":		
			switch (choiceSensor.toUpperCase()) {

				case "L":
					MainDispatcher.getInstance().callView(sub_package + "SensorRead", null);
					break;
	
				case "I":
					MainDispatcher.getInstance().callView(sub_package + "SensorInsert", null);
					break;
	
				case "M":
					MainDispatcher.getInstance().callView(sub_package + "SensorUpdate", null);
					break;
					
				case "C":
					MainDispatcher.getInstance().callView(sub_package + "SensorDelete", null);
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
