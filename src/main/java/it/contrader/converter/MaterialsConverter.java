package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.MaterialsDTO;
import it.contrader.model.Materials;

public class MaterialsConverter {

	public MaterialsDTO toDTO(Materials materials) {

		MaterialsDTO materialsDTO = new MaterialsDTO( materials.getName(),materials.getId());
		return materialsDTO;

	}

	public Materials toEntityInsert(MaterialsDTO materialsDTO) {

		Materials materials = new Materials(materialsDTO.getMaterialName());
		return materials;

	}
	
	
	public Materials toEntityUpdate(MaterialsDTO materialsDTO) {

		Materials materials = new Materials(materialsDTO.getMaterialName(), materialsDTO.getid());
		return materials;

	}

	public List<MaterialsDTO> toDTOList(List<Materials> materialsList) {
		
		List<MaterialsDTO> materialsDTOList = new ArrayList<MaterialsDTO>();

		
		for (Materials materials : materialsList) {
			
			materialsDTOList.add(toDTO(materials));
		}
		return materialsDTOList;
	}
}
