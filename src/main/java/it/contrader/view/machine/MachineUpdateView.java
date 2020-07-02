package it.contrader.view.machine;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class MachineUpdateView extends AbstractView{
	private Request request;
	
	private int id;
	private String model;
	private double init_quantity;
	private double final_quantity;
	
	private final String mode = "UPDATE";

	public MachineUpdateView() {
	}
	
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Machine", null);
		}
		
	}

	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id della Macchina da modificare:");
			id = Integer.parseInt(getInput());
			System.out.println("cambia il Modello:");
			model = getInput();
			System.out.println("cambia quantità iniziale:");
			init_quantity = Double.parseDouble(getInput());
			System.out.println("cambia quantità finale:");
			final_quantity = Double.parseDouble(getInput());
			
		} catch (Exception e) {

		}
		
	}

	@Override
	public void submit() {
		try {
		request = new Request();
		request.put("id", id);
		request.put("modello", model);
		request.put("init_quantity", init_quantity);
		request.put("final_quantity", final_quantity);
		request.put("modeMachine", mode);
		MainDispatcher.getInstance().callAction("Machine", "doControl", request);
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
	}
		
  }

