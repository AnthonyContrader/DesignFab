package it.contrader.dto;

public class SensorDTO{
	private int id;
	private String sensortype;
	
	public SensorDTO(){
		
	}
	
	public SensorDTO (String sensortype) {
		this.sensortype = sensortype;
	}
	
	public SensorDTO (int id, String sensortype) {
		this.id = id;
		this.sensortype = sensortype;
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
		return  id + "\t"  + sensortype;
	}
	
}