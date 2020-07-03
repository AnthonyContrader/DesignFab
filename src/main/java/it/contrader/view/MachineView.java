package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.MachinesDTO;
import it.contrader.main.MainDispatcher;

public class MachineView extends AbstractView {
	
	private Request request;
	private String choice;

	public MachineView() {
		
	}


	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione Macchinari ----------------\n");
			System.out.println("ID\tModello\tQuantità Iniziale\tQuantità Finale");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<MachinesDTO> machines = (List<MachinesDTO>) request.get("machines");
			for (MachinesDTO m: machines)
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
		request.put("modeMachine", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Machine", "doControl", this.request);
	}


}
