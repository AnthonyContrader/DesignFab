package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Materials {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long IdMaterials;
	
	
	@Column(unique = true)
	private String MaterialName;
	private int MaterialsQuantity;
	
	

}


