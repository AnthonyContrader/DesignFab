package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.MaterialsConverter;
import it.contrader.dao.MaterialsRepository;
import it.contrader.dto.MaterialsDTO;
import it.contrader.model.Materials;
import it.contrader.model.Materials.Materialtype;


@Service
public class MaterialsService extends AbstractService<Materials, MaterialsDTO> {
	
	@Autowired
	private MaterialsConverter converter;
	@Autowired
	private MaterialsRepository repository;
	
	public MaterialsDTO  findByMaterialType(Materialtype materialType) {
		return converter.toDTO(((MaterialsRepository)repository).findByMaterialType(materialType));
		
	}

}
