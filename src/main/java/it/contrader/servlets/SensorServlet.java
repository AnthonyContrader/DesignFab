package it.contrader.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.SensorDTO;
import it.contrader.service.SensorService;
import it.contrader.service.Service;

/**
 * Servlet implementation class SensorServlet
 */
public class SensorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public void updateList(HttpServletRequest request) {
		Service<SensorDTO> service = new SensorService();
		List<SensorDTO> listDTO = service.getAll();
		
		List<SensorDTO> listFinaleDTO= new ArrayList<SensorDTO>();
		for (SensorDTO sensorDTO : listDTO) {
			SensorDTO i=((SensorService) service).getModelloMacchina(sensorDTO.getId_machine());
			listFinaleDTO.add(i);
			
		}
		request.setAttribute("list", listFinaleDTO);
	}

	public SensorServlet() {
		super();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Service<SensorDTO> sensorService = new SensorService();
		String mode = req.getParameter("mode");
		SensorDTO sensorDTO;
		int id;
		boolean ans;
		switch (mode.toUpperCase()) {
		
		case "SENSORLIST":
			updateList(req);
			getServletContext().getRequestDispatcher("/sensor/sensormanager.jsp").forward(req, resp);
			break;
			
		case "READ":
			id = Integer.parseInt(req.getParameter("id"));
			sensorDTO = sensorService.read(id);
			req.setAttribute("dto", sensorDTO);
			if (req.getParameter("update") == null) {
				getServletContext().getRequestDispatcher("/sensor/sensorread.jsp").forward(req, resp);
			} else
				getServletContext().getRequestDispatcher("/sensor/sensorupdate.jsp").forward(req, resp);
			break;

		case "INSERT":
			String sensor_type = req.getParameter("sensor_type").toString();
			int id_machine = Integer.parseInt(req.getParameter("id_machine"));
			sensorDTO = new SensorDTO(sensor_type, id_machine);
			ans = sensorService.insert(sensorDTO);
			updateList(req);
			getServletContext().getRequestDispatcher("/sensor/sensormanager.jsp").forward(req, resp);
			break;
			
		case "UPDATE":
			 sensor_type = req.getParameter("sensor_type");
			 sensorDTO = new SensorDTO(sensor_type);
			 ans = sensorService.update(sensorDTO);
			 updateList(req);
			 getServletContext().getRequestDispatcher("/sensor/sensormanager.jsp").forward(req, resp);
			 break;
			 
		case "DELETE":
			id = Integer.parseInt(req.getParameter("id"));
			ans = sensorService.delete(id);
			req.setAttribute("ans", ans);
			updateList(req);
			getServletContext().getRequestDispatcher("/sensor/sensormanager.jsp").forward(req, resp);
			break;
		}
			
	}


}
