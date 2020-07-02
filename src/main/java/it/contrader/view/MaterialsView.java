package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.MaterialsDTO;
import it.contrader.main.MainDispatcher;


public class MaterialsView  extends AbstractView{
	
	private Request request;
	private String choice;


	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione Materiali ----------------\n");
			System.out.println("ID\tTipo di materiale");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<MaterialsDTO> materials = (List<MaterialsDTO>) request.get("materials");
			for (MaterialsDTO m: materials)
				System.out.println(m);
			System.out.println();
		}
	}


	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

		this.choice = getInput();

		
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("modeMaterials", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Materials", "doControl", this.request);
	}


}
