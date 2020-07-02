package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.SensorDTO;
import it.contrader.main.MainDispatcher;

public class SensorView extends AbstractView {

	private Request request;
	private String choice;
	
	@Override
	public void showResults(Request request) {

		if (request != null) {
			System.out.println("Ti mostro la lista dei sensori");

			List<SensorDTO> sensorDTO = (List<SensorDTO>) request.get("sensors");
			for (SensorDTO sensor : sensorDTO)
				System.out.println(sensor);
			System.out.println();
		}

	}

	@Override
	public void showOptions() {

		System.out.println("Scegli l'operazione da eseguire ");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");
		
		this.choice = getInput();
	}

	@Override
	public void submit() {
		
		request = new Request();
		request.put("choice", choice);
		request.put("modeSensor", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Sensor", "doControl", this.request);
	}

}
