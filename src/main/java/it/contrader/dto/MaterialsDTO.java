package it.contrader.dto;

import java.util.List;

import it.contrader.model.Machine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MaterialsDTO {
	
	private Long IdMaterials;
	
	private String MaterialName;
	
	private Double MaterialsQuantity;
	
	//private List<Machine> machinesOnMaterial;
}
