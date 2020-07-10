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
    	
		MaterialsDTO dtoMaterials;
		MachinesDTO dtoMachine;
		int id_machine;
		String material_name;
		boolean ansMaterials;
		boolean ansMachine;
		
		Random random = new Random();
		int randomInteger = random.nextInt(96);
 
	 double init_quantity_machine = Double.parseDouble(request.getParameter("quantity"));
	 double final_quantity_machine = (init_quantity_machine * randomInteger) /100 ;
	 double quantity = final_quantity_machine /3;
	 
	 id_machine = Integer.parseInt(request.getParameter("id_machine"));
	 material_name =request.getParameter("material_name");
	 
	 dtoMaterials = new MaterialsDTO(material_name,quantity);
	 dtoMachine = new MachinesDTO( init_quantity_machine,final_quantity_machine, id_machine);
	 
	 ansMaterials = serviceMaterials.updateQuantity(dtoMaterials);
	 ansMachine = serviceMachine.updateQuantity(dtoMachine);
	 listDTO.add(dtoMaterials);
	 
	// request.setAttribute("dtoMaterials", dtoMaterials);
	 request.setAttribute("dtoMachine", dtoMachine);
	 request.setAttribute("list", listDTO);
	 getServletContext().getRequestDispatcher("/homeResult.jsp").forward(request, response);

    
    
    
    }
   
}
