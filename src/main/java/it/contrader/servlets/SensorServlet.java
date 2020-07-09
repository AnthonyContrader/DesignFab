package it.contrader.servlets;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.MachinesDTO;
import it.contrader.dto.SensorDTO;
import it.contrader.service.SensorService;
import it.contrader.service.Service;

/**
 * Servlet implementation class SensorServlet
 */
public class SensorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(SensorServlet.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public void updateList(HttpServletRequest request) {
		Service<SensorDTO> service = new SensorService();
		List<SensorDTO> listDTO = service.getAll();
		request.setAttribute("list", listDTO);
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
			String tmp = req.getParameter("update");
			if (req.getParameter("update") == null) {
				getServletContext().getRequestDispatcher("/sensor/sensorread.jsp").forward(req, resp);
			} else {
				getServletContext().getRequestDispatcher("/sensor/sensorupdate.jsp").forward(req, resp);
			}
			break;

		case "INSERT":
			String sensor_type = req.getParameter("sensor_type").toString();
			int id_machine = Integer.parseInt(req.getParameter("id_machine"));
			sensorDTO = new SensorDTO(sensor_type, id_machine);
			try {
				ans = sensorService.insert(sensorDTO);
				req.setAttribute("ans", ans);
				updateList(req);
				getServletContext().getRequestDispatcher("/sensor/sensormanager.jsp").forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case "UPDATE":
			sensor_type = req.getParameter("sensor_type").toString();
			id_machine = Integer.parseInt(req.getParameter("id_machine"));
			id = Integer.parseInt(req.getParameter("id"));
			sensorDTO = new SensorDTO(id, sensor_type, id_machine);
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
