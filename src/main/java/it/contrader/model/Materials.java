package it.contrader.model;

public class Materials {
	
	private int id;
	
	 
	private String material_name;
	
	public Materials() {
		
	}

	public Materials (String name) {
		this.material_name = name;
	}
	
	public Materials (String name, int id) {
		this.material_name = name;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return material_name;
	}

	public void setName(String name) {
		this.material_name = name;
	}

	@Override
	public String toString() {
		return  id + "\t\t"  + material_name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Materials other = (Materials) obj;
		if (id != other.id)
			return false;
		if (material_name == null) 
			if (other.material_name != null)
				return false;
	    else if (!material_name.equals(other.material_name))
	    	return false;
	
		return true;
	}
	
}
