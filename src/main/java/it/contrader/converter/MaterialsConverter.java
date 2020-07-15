package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.MaterialsDTO;
import it.contrader.model.Materials;


@Component
public class MaterialsConverter extends AbstractConverter<Materials, MaterialsDTO> {
	
	@Override 
	public Materials toEntity(MaterialsDTO materialsDTO) {
		Materials material = null;
		if(materialsDTO != null) {
			material = new Materials(materialsDTO.getIdMaterials(), materialsDTO.getMaterialName(), materialsDTO.getMaterialsQuantity(), materialsDTO.getMachinesOnMaterial());
		}
		return material;
	}
	
	@Override
	public MaterialsDTO toDTO(Materials material){
		MaterialsDTO materialDTO = null;
		if(material != null) {
			materialDTO = new MaterialsDTO(material.getIdMaterials(), material.getMaterialName(), material.getMaterialsQuantity(), material.getMachinesOnMaterial());
		}
		return materialDTO;
	}
}
