package it.contrader.view.materials;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class MaterialsDeleteView extends AbstractView {
	private Request request;

	private int id;
	private final String mode = "DELETE";
	
	
	public MaterialsDeleteView() {
		
	}
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Materials", null);
		}
		
	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci ID del materiale da Cancellare:");
		id = Integer.parseInt(getInput());
		
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("modeMaterials", mode);
		MainDispatcher.getInstance().callAction("Materials", "doControl", request);
		
	}

}
