package it.contrader.service;

import it.contrader.converter.MachinesConverter;
import it.contrader.dao.MachinesDAO;
import it.contrader.dto.MachinesDTO;
import it.contrader.model.Machines;

public class MachineService extends AbstractService<Machines, MachinesDTO>{
	
	public MachineService(){
		this.dao = new MachinesDAO();
		this.converter = new MachinesConverter();
	}
}