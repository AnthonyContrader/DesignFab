package it.contrader.view.machine;

import it.contrader.controller.Request;
import it.contrader.dto.MachinesDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class MachineReadView extends AbstractView{

private Request request;

	private int id;
	
	private final String mode = "READ";
	
	MachineReadView() {
		
	}
	
	@Override
	public void showResults(Request request) {
		if (request != null) {
			MachinesDTO machine = (MachinesDTO) request.get("machine");
			System.out.println(machine);
			MainDispatcher.getInstance().callView("Machine", null);
		}
		
	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID del macchinario:");
		id = Integer.parseInt(getInput());
		
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Machine", "doControl", request);
		
	}

}
