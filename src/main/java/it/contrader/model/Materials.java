package it.contrader.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import it.contrader.model.User.Usertype;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Materials {
	
	public enum Materialtype {
		GENERIC, GLASS, PAPER, PLASTIC, INDIFFERENZIATA
	}
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMaterials;
	
	@Column(unique = true)
	private String materialName;
	
	private Double materialsQuantity;
	
	private Materialtype materialType;
	
	
	/*@OneToOne(mappedBy = "materials", cascade = CascadeType.ALL)
	private Sensor sensor;*/
	

}


