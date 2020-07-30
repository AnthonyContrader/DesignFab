package it.contrader.service;

import java.util.List;

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
	
	public List<MaterialsDTO> findAllByMaterialType(Materialtype materialName) {
		return converter.toDTOList(repository.findAllByMaterialType(materialName));
		
	}
	
	public List<MaterialsDTO> calcolaService(double quantityMaterial){
		List<MaterialsDTO> list= (List<MaterialsDTO>) this.getAll();
		System.out.println("listaaaa1" + list);
		Long id_materialsGenerico = null;
		Materialtype material_type = null;
		String material_name = null ;
		
		for (MaterialsDTO u : list) {
			System.out.println(u.getMaterialType());
			if (u.getMaterialType().toString().equals("GENERIC")) {
				id_materialsGenerico = u.getIdMaterial();
				material_type = u.getMaterialType();
				material_name= u.getMaterialName();
			}
		}
		MaterialsDTO dto = new MaterialsDTO();
		dto.setMaterialType(material_type);
		dto.setIdMaterial(id_materialsGenerico);
		dto.setMaterialsQuantity(quantityMaterial);
		dto.setMaterialName(material_name);
		System.out.println("dtoooooo"+dto);
		this.update(dto);
		//setAll(request);
		double quantity = 0;
		Double Materialsx = quantityMaterial;
		for (int i = 0; i < list.size() - 1; i++) {
			if (!list.get(i).getMaterialType().toString().equals("GENERIC") && quantityMaterial > 0 && i == 0) {

				quantity = Math.floor((Math.random() * (Materialsx * 2 / 3 - 0.0) + 0.0));
				Materialsx -= quantity;

				list.get(i).setMaterialsQuantity(list.get(i).getMaterialsQuantity() + quantity);

				this.update(list.get(i));
			}
			if (!list.get(i).getMaterialType().toString().equals("GENERIC") && quantityMaterial > 0) {

				quantity = Math.floor((Math.random() * (Materialsx - 0.0) + 0.0));
				Materialsx -= quantity;

				list.get(i).setMaterialsQuantity(list.get(i).getMaterialsQuantity() + quantity);

				this.update(list.get(i));
			}

		}
		
		list.get(list.size() - 1).setMaterialsQuantity(Materialsx + list.get(list.size() - 1).getMaterialsQuantity() );
		this.update(list.get(list.size() - 1));
		List<MaterialsDTO> finalList= (List<MaterialsDTO>) this.getAll();
		System.out.println("final list"+finalList);
		return finalList ;

	}

		
	}
	


