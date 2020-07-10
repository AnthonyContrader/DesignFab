package it.contrader.service;

import java.util.List;

import it.contrader.converter.MaterialsConverter;
import it.contrader.dao.MaterialsDAO;
import it.contrader.dto.MaterialsDTO;
import it.contrader.model.Materials;

public class MaterialsService extends AbstractService<Materials, MaterialsDTO>  {

	
	public MaterialsService(){
		this.dao = new MaterialsDAO();
		this.converter = new MaterialsConverter();
	}
	// questo metodo aggiorna tutte le quantità  della tabella Materials
	public List<MaterialsDTO> updateAll(List<MaterialsDTO> listDTO, double quantity) {
		
		for(MaterialsDTO m : listDTO) {
			m.setQuantity(quantity);
			this.updateQuantity(m);						
		}
		
		
		return this.getAll();
		
	}
}
