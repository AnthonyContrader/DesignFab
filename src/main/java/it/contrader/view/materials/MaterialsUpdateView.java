package it.contrader.view.materials;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class MaterialsUpdateView extends AbstractView {

	private Request request;

	private int id;
	private String material_name;
	private final String mode = "UPDATE";

	MaterialsUpdateView() {

	}

	@Override
	public void showResults(Request request) {

		if (request != null) {
			System.out.println(request.toString());
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Materials", null);
		}

	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci id del materiale da modificare:");
		id = Integer.parseInt(getInput());
		System.out.println("cambia il tipo di materiale:");
		material_name = getInput();

	}

	@Override
	public void submit() {
		try {
			request = new Request();
			request.put("id", id);
			request.put("material_name", material_name);
			request.put("modeMaterials", mode);
			MainDispatcher.getInstance().callAction("Materials", "doControl", request);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

	}

}
