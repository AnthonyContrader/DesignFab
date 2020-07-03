package it.contrader.view.machine;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class MachineInsertView extends AbstractView{

	private Request request;
	
	private String model;
	private double init_quantity;
	private double final_quantity;
	
	private final String mode = "INSERT";
	 
	
	public MachineInsertView() {
		
	}
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Machine", null);
		}
		
	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci il Modello del Macchinario: ");
		model = getInput();
		System.out.println("Inserisci la Quantit� di materiale inserita: ");
		init_quantity = Double.parseDouble(getInput());	
		final_quantity = (init_quantity /100) * 30;
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("modello", model);
		request.put("init_quantity", init_quantity);
		request.put("final_quantity", final_quantity);
		request.put("modeMachine", mode);
		MainDispatcher.getInstance().callAction("Machine", "doControl", request);
		
	}
	

}
