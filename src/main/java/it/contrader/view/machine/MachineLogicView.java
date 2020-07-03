package it.contrader.view.machine;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class MachineLogicView extends AbstractView{

private Request request;
	
	private int id;
	private double init_quantity;
	private double final_quantity;
	
	private final String mode = "CALCULATE";
	 
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Machine", null);
		}	
	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci la Quantità di materiale prodotta:");
		final_quantity = (init_quantity /100) * 30;
		
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("final_quantity", final_quantity);
		request.put("modeLogic", mode);
		MainDispatcher.getInstance().callAction("Logic", "doControl", request);
		
	}

}
