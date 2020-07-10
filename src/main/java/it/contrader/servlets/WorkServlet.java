package it.contrader.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.MachinesDTO;
import it.contrader.dto.MaterialsDTO;
import it.contrader.service.MachineService;
import it.contrader.service.MaterialsService;
import it.contrader.service.Service;

public class WorkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public WorkServlet() {

	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<MaterialsDTO> serviceMaterials = new MaterialsService();
		Service<MachinesDTO> serviceMachine = new MachineService();
		List<MaterialsDTO> listDTO = serviceMaterials.getAll();

		MachinesDTO dtoMachine;
		String model;
		double init_quantity_machine;
		boolean ansMaterials;
		boolean ansMachine;

		Random random = new Random();
		int randomInteger = random.nextInt(96);

		model = request.getParameter("model_machine");
		init_quantity_machine = Double.parseDouble(request.getParameter("quantity"));

		double final_quantity_machine = (init_quantity_machine * randomInteger) / 100;
		double quantity = final_quantity_machine / 3;

		dtoMachine = new MachinesDTO(model, init_quantity_machine, final_quantity_machine);

		List<MaterialsDTO> listDB = serviceMaterials.getAll();

		ansMachine = serviceMachine.updateQuantity(dtoMachine);

		listDTO = ((MaterialsService) serviceMaterials).updateAll(listDB, quantity);

		request.setAttribute("dtoMachine", dtoMachine);
		request.setAttribute("list", listDTO);
		getServletContext().getRequestDispatcher("/homeResult.jsp").forward(request, response);

	}

}
