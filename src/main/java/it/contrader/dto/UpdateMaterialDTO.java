package it.contrader.dto;

import it.contrader.model.Materials.Materialtype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMaterialDTO {

	private Materialtype materialType;
}
