package it.contrader.view.sensor;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class SensorDeleteView extends AbstractView {

	private Request request;

	private int id;
	private final String mode = "DELETE";

	public SensorDeleteView() {
	
	}

	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Sensor", null);
		}
	}


	@Override
	public void showOptions() {
		System.out.println("Inserisci id dell'utente:");
		id = Integer.parseInt(getInput());

	}

	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("modeSensor", mode);
		MainDispatcher.getInstance().callAction("Sensor", "doControl", request);
	}
}
