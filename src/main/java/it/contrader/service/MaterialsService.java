package it.contrader.service;

import it.contrader.converter.MaterialsConverter;
import it.contrader.dao.MaterialsDAO;
import it.contrader.dto.MaterialsDTO;
import it.contrader.model.Materials;

public class MaterialsService extends AbstractService<Materials, MaterialsDTO>  {

	
	public MaterialsService(){
		this.dao = new MaterialsDAO();
		this.converter = new MaterialsConverter();
	}
	
}
