package it.contrader.view.materials;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class MaterialsInsertView extends AbstractView{

	private Request request;
	private String material_name;
	
	private final String mode = "INSERT";
	
	
	public MaterialsInsertView() {
		
	}
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Materials", null);
		}
		
	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci il tipo di Materiale:");
		material_name = getInput();
		
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("material_name", material_name);
		request.put("modeMaterials", mode);
		MainDispatcher.getInstance().callAction("Materials", "doControl", request);		
	}

}
