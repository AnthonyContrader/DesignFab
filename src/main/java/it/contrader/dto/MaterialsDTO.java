package it.contrader.dto;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import it.contrader.model.Materials.Materialtype;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idMaterial")

public class MaterialsDTO {
	
	private Long idMaterial;
	
	private String materialName;
	
	private Double materialsQuantity;
	
	private Materialtype materialType;
	}
