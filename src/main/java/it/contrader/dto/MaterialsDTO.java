package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MaterialsDTO {
	
	private long IdMaterials;
	
	private String MaterialName;
	
	private int MaterialsQuantity;
}
