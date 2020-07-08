package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.MaterialsDTO;
import it.contrader.service.MaterialsService;
import it.contrader.service.Service;

public class MaterialsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MaterialsServlet() {
	}

	public void updateList(HttpServletRequest request) {
		Service<MaterialsDTO> service = new MaterialsService();
		List<MaterialsDTO> listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<MaterialsDTO> service = new MaterialsService();
		String mode = request.getParameter("mode");
		MaterialsDTO dto;
		int id;
		boolean ans;
		try {
		switch (mode.toUpperCase()) {

		case "MATERIALSLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/materials/materialManager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);

			if (request.getParameter("update") == null) {
				getServletContext().getRequestDispatcher("/materials/readMaterial.jsp").forward(request, response);

			}

			else
				getServletContext().getRequestDispatcher("/materials/updateMaterial.jsp").forward(request, response);
			break;

		case "INSERT":
			
			String material_name = request.getParameter("material_name").toString();
			double quantity = Double.parseDouble(request.getParameter("quantity_materials"));
			dto = new MaterialsDTO(material_name, quantity);	
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/materials/materialManager.jsp").forward(request, response);
			break;

		case "UPDATE":
			 material_name = request.getParameter("material_name").toString();
			 quantity = Double.parseDouble(request.getParameter("quantity_materials"));
			id = Integer.parseInt(request.getParameter("id"));
			dto = new MaterialsDTO( material_name, quantity,id);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/materials/materialManager.jsp").forward(request, response);
		
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/materials/materialManager.jsp").forward(request, response);
			break;
		}
		}catch(Exception e) {
			e.printStackTrace();			
			request.setAttribute("ERRORE", e.getLocalizedMessage());
			getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}

}
