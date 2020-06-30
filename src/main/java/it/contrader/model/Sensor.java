package it.contrader.model;

public class Sensor {
	int id;
	String sensor_type;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSensor_type() {
		return sensor_type;
	}
	public void setSensor_type(String sensor_type) {
		this.sensor_type = sensor_type;
	}
	
	
	public Sensor() {
	}
	public Sensor(int id, String sensor_type) {
		this.id = id;
		this.sensor_type = sensor_type;
	}
	
	
	public Sensor(String sensor_type) {
		this.sensor_type = sensor_type;
	}
	@Override
	public String toString() {
		return "Sensor [id=" + id + ", sensor_type=" + sensor_type + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Sensor other = (Sensor) obj;
		if (id != other.id)
			return false;
		if (sensor_type == null) 
			if (other.sensor_type != null)
				return false;
	    else if (!sensor_type.equals(other.sensor_type))
	    	return false;
	
		return true;
	}
}
