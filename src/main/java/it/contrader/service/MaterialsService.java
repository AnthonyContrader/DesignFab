package it.contrader.service;

import java.util.List;

import it.contrader.converter.MaterialsConverter;
import it.contrader.dao.MaterialsDAO;
import it.contrader.dto.MaterialsDTO;
public class MaterialsService {

	
	private MaterialsDAO materialsDAO;
  	private MaterialsConverter materialsConverter;
	
	
	public MaterialsService(){ //costruttore 
		this.materialsDAO = new MaterialsDAO();
		this.materialsConverter = new MaterialsConverter();
	}
	

	public List<MaterialsDTO> getAll() { //restituisce una lista di oggetti in DTO
		return materialsConverter.toDTOList(materialsDAO.getAllMaterials());
	}

	public boolean insert(MaterialsDTO dto) { //CREATE DTO in oggetto e lo passa al DAO
		return materialsDAO.insert(materialsConverter.toEntity(dto));
	}

	public MaterialsDTO read(int id) { //READ  oggetto in DTO
		return materialsConverter.toDTO(materialsDAO.getMaterialRead(id));
	}

	public boolean update(MaterialsDTO dto) { //UPDATE passa il DTO al DAO per modifica
		return materialsDAO.update(materialsConverter.toEntity(dto));
	}

	public boolean delete(int id) { //DELETE
		// Questo mtodo chiama direttamente il DAO
		return materialsDAO.delete(id);
	}
	
	
}
