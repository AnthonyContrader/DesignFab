package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Machine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_machine;

	@Column(unique = true)
	private String machine_name;

	private String materialName;

	@ManyToOne
	private Sensor sensor;

	/*
	 * @ManyToMany(fetch = FetchType.EAGER,cascade = { CascadeType.ALL })
	 * 
	 * @JoinTable( name = "machine_materials", joinColumns = @JoinColumn(name =
	 * "machine_id_FK"), inverseJoinColumns = @JoinColumn(name = "material_id_FK") )
	 * private List<Materials> materialsOnMachine;
	 */
}
