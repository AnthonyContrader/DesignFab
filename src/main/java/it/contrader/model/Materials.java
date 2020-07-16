package it.contrader.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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
	private Long IdMaterials;
	
	
	@Column(unique = true)
	private String MaterialName;
	private Double MaterialsQuantity;
	
	@OneToOne(mappedBy = "materials", cascade = CascadeType.ALL)
	private Sensor sensor;
	

}


