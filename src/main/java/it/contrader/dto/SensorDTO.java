package it.contrader.dto;

public class SensorDTO{
	private int id;
	private String sensortype;
	private int id_machine;
	private String modello_macchina;
	
	
	
	public int getId_machine() {
		return id_machine;
	}

	public void setId_machine(int id_machine) {
		this.id_machine = id_machine;
	}

	public SensorDTO(){
		
	}
	
	public SensorDTO (String sensortype, String modello_macchina ) {
		this.modello_macchina=modello_macchina;
		this.sensortype = sensortype;
	}
	
	public SensorDTO (String sensortype) {
		this.sensortype = sensortype;
		
	}
	
	public SensorDTO (int id, String sensortype) {
		this.id = id;
		this.sensortype = sensortype;
	}
	
	public SensorDTO(String sensortype, int id_machine) {
		this.sensortype = sensortype;
		this.id_machine = id_machine;
		
	}
	
	public SensorDTO (int id, String sensortype, int id_machine) {
		this.id = id;
		this.sensortype = sensortype;
		this.id_machine = id_machine;
		this.modello_macchina = "";
	}
	
	public SensorDTO(int id2, String sensor_type, String modelloMacchina) {
		this.id = id2;
		this.sensortype = sensor_type;
		this.modello_macchina = modelloMacchina;
	}

	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getSensortype() {
		return this.sensortype;
	}
	public void setSensortype(String sensortype) {
		this.sensortype = sensortype;
	}
	
	@Override
	public String toString() {
		return  id + "\t"  + sensortype + "\t" + id_machine;
	}

	public String getModello_macchina() {
		return modello_macchina;
	}

	public void setModello_macchina(String modello_macchina) {
		this.modello_macchina = modello_macchina;
	}
	
}