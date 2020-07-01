package it.contrader.view.machine;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class MachineDeleteView  extends AbstractView {
	private Request request;

	private int id;
	private final String mode = "DELETE";
	
	
	MachineDeleteView() {
		
	}
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Machine", null);
		}
		
	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci id della macchina:");
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
