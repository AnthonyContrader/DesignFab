package it.contrader.view.sensor;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class SensorUpdateView extends AbstractView {

	private Request request;
	private int id;
	private String sensor_type;
	private final String mode = "UPDATE";

	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Sensor", null);
		}
	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci id del sensor da modificare:");
		id = Integer.parseInt(getInput());
		System.out.println("Inserisci il tipo di sensore:");
		sensor_type = getInput();

	}

	@Override
	public void submit() {
		request = new Request();
		request.put("id_sensor", id);
		request.put("sensor_type", sensor_type);
		request.put("modeSensor", mode);
		MainDispatcher.getInstance().callAction("Sensor", "doControl", request);

	}

}
