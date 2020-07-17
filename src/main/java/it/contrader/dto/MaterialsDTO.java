package it.contrader.dto;


import it.contrader.model.Materials.Materialtype;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MaterialsDTO {
	
	private Long idMaterials;
	
	private String materialName;
	
	private Double materialsQuantity;
	
	private Materialtype materialType;
	}
