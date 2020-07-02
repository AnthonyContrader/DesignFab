package it.contrader.view.materials;

import it.contrader.controller.Request;
import it.contrader.dto.MaterialsDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class MaterialsReadView  extends AbstractView{

		private Request request;
		private int id;		
		private final String mode = "READ";
		
				
		public MaterialsReadView() {
			
		}
		
		@Override
		public void showResults(Request request) {
			if (request != null) {
				MaterialsDTO materials = (MaterialsDTO) request.get("materials");
				System.out.println(materials);
				MainDispatcher.getInstance().callView("Materials", null);
			}
			
		}

		@Override
		public void showOptions() {
			System.out.println("Inserisci l'ID del Materiale:");
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
