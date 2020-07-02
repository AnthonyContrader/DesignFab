package it.contrader.view.materials;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class MaterialsUpdateView extends AbstractView{

private Request request;

	private int id;
	private String materials_name;
	private final String mode = "READ";
	
	MaterialsUpdateView() {
		
	}

	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Materials", null);
		}
		
	}

	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id del materiale da modificare:");
			id = Integer.parseInt(getInput());
			System.out.println("cambia il tipo di materiale:");
			materials_name = getInput();
			
		} catch (Exception e) {

		}
		
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("materials_name", materials_name);
		request.put("modeMaterials", mode);
		MainDispatcher.getInstance().callAction("Materials", "doControl", request);
		}
		
	}


