package it.contrader.view.sensor;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class SensorInsertView extends AbstractView {
	private Request request;

	private String sensor_type;
	private int id_machine;
	private final String mode = "INSERT";

	public SensorInsertView() {

	}

	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Sensor", null);
		}
	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci il tipo di sensore:");
		sensor_type = getInput();
		System.out.println("Inserisci l'id della macchina alla quale associare il sensore");
		id_machine = Integer.parseInt(getInput());
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("sensor_type", sensor_type);
		request.put("id_machine", id_machine);
		request.put("modeSensor", mode);
		MainDispatcher.getInstance().callAction("Sensor", "doControl", request);
	}

}
