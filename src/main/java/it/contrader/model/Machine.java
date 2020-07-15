package it.contrader.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

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
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = { CascadeType.PERSIST })
    @JoinTable(
        name = "machine_materials", 
        joinColumns =  @JoinColumn(name = "machine_id_FK"),
        inverseJoinColumns = @JoinColumn(name = "material_id_FK") 
    )
	private List<Materials> materialsOnMachine = new ArrayList<Materials>();
}
