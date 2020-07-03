package it.contrader.service;

import java.util.List;

import it.contrader.converter.MachinesConverter;
import it.contrader.dao.MachinesDAO;
import it.contrader.dto.MachinesDTO;

public class MachineService {


	private MachinesDAO machinesDAO;
	private MachinesConverter machinesConverter;
	
	
	public MachineService(){ //costruttore 
		this.machinesDAO = new MachinesDAO();
		this.machinesConverter = new MachinesConverter();
	}
	

	public List<MachinesDTO> getAll() { //restituisce una lista di oggetti in DTO
		return machinesConverter.toDTOList(machinesDAO.getAll());
	}

	public boolean insert(MachinesDTO dto) { //CREATE DTO in oggetto e lo passa al DAO
		return machinesDAO.insert(machinesConverter.toEntityInsert(dto));
	}

	public MachinesDTO read(int id) { //READ  oggetto in DTO
		return machinesConverter.toDTO(machinesDAO.read(id));
	}

	public boolean update(MachinesDTO dto) { //UPDATE passa il DTO al DAO per modifica
		return machinesDAO.update(machinesConverter.toEntity(dto));
	}

	public boolean delete(int id) { //DELETE  chiama direttamente il DAO
		return machinesDAO.delete(id);
	}
	
	
}
