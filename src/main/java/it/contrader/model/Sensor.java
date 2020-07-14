package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import it.contrader.model.User.Usertype;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor //costruttore con tutti i parametri
@NoArgsConstructor  //costruttore vuoto
@Data   //getter e setter
@Entity //dici che è una tabella
public class Sensor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_sensor;
	
	@Column(unique = true)
	private String name_sensor;
	@OneToMany(mappedBy= "Machine")
	@JoinColumn(name="id_machine")
	private Long id_machine;
	
	

}
