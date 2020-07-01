package it.contrader.controller;

import java.util.List;

import it.contrader.dto.MachinesDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.MachineService;

public class MachineController implements Controller {

	private static String sub_package = "machine.";
	
	private MachineService machineService;

	public MachineController() {
		this.machineService = new MachineService();
	}
	
	
	@Override
	public void doControl(Request request) {
		
		
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");
			
	
		 int id;
		 String model;
		 double init_quantity;
		 double final_quantity;
		 
		 switch (mode) {
		 
		 case "READ":
				id = Integer.parseInt(request.get("id").toString());
				MachinesDTO machineDTO = machineService.read(id);
				request.put("machine", machineDTO);
				MainDispatcher.getInstance().callView(sub_package + "MachineRead", request);
				break;
				
		 case "INSERT":
				model = request.get("modello").toString();
				init_quantity = Double.parseDouble(request.get("init_quantity").toString());
				final_quantity =Double.parseDouble( request.get("final_quantity").toString());
				
				MachinesDTO machineToInsert = new MachinesDTO(model, init_quantity, final_quantity);
				machineService.insert(machineToInsert);
				request = new Request();
				request.put("mode", "mode");
				MainDispatcher.getInstance().callView(sub_package + "MachineInsert", request);
				break;
		 
		 case "DELETE":
				id = Integer.parseInt(request.get("id").toString());
				machineService.delete(id);
				request = new Request();
				request.put("mode", "mode");
				MainDispatcher.getInstance().callView(sub_package + "MachineDelete", request);
				break;
				
		 case "UPDATE":			 
				id = Integer.parseInt(request.get("id").toString());
				model = request.get("modello").toString();
				init_quantity = Double.parseDouble(request.get("init_quantity").toString());
				final_quantity =Double.parseDouble( request.get("final_quantity").toString());
				
				MachinesDTO machineToUpdate = new MachinesDTO(model, init_quantity, final_quantity);
				machineToUpdate.setId(id);
				machineService.update(machineToUpdate);
				request = new Request();
				request.put("mode", "mode");
				MainDispatcher.getInstance().callView(sub_package + "MachineUpdate", request);
				break;
				
		 case "MACHINELIST":
				List<MachinesDTO> machinesDTO = machineService.getAll();
				request.put("machines", machinesDTO);
				MainDispatcher.getInstance().callView("Machine", request);
				break;
		 
		 case "GETCHOICE":
				
		switch (choice.toUpperCase()) {
		
		case "L":
			MainDispatcher.getInstance().callView(sub_package + "MachineRead", null);
			break;
			
		case "I":
			MainDispatcher.getInstance().callView(sub_package + "MachineInsert", null);
			break;
			
		case "M":
			MainDispatcher.getInstance().callView(sub_package + "MachineUpdate", null);
			break;
			
		case "C":
			MainDispatcher.getInstance().callView(sub_package + "MachineDelete", null);
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
