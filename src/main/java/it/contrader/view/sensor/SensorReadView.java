package it.contrader.view.sensor;

import it.contrader.controller.Request;
import it.contrader.dto.SensorDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class SensorReadView extends AbstractView {

	private int id;
	private Request request;
	private final String mode = "READ";

	@Override
	public void showResults(Request request) {
		if (request != null) {
			SensorDTO sensor = (SensorDTO) request.get("sensor");
			System.out.println(sensor);
			MainDispatcher.getInstance().callView("Sensor", null);
		}
	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID del Sensore:");
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
