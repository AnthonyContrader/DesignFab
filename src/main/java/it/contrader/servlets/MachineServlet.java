package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.MachinesDTO;
import it.contrader.service.MachineService;
import it.contrader.service.Service;

public class MachineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MachineServlet() {
		super();
	}

	public void updateList(HttpServletRequest request) {
		Service<MachinesDTO> service = new MachineService();
		List<MachinesDTO> listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<MachinesDTO> service = new MachineService();
		String mode = request.getParameter("mode");
		MachinesDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "MACHINELIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/machine/machineManager.jsp").forward(request, response);
			break;
			
		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/machine/readMachine.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/machine/updateMachine.jsp").forward(request, response);
			
			break;
		}
	}

}
