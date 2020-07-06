package it.contrader.model;

public class Materials {
	
	private int id;
	
	private String material_name;
	
	private double quantity;
	
	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public Materials() {
		
	}

	public Materials (String name) {
		this.material_name = name;
	}
	public Materials (String name, double quantity) {
		this.material_name = name;
		this.quantity = quantity;
	}
	
	public Materials (String name, int id) {
		this.material_name = name;
		this.id = id;
	}
	
	public Materials (String name, double quantity, int id) {
		this.material_name = name;
		this.quantity = quantity;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaterial_name() {
		return material_name;
	}

	public void setMaterial_name(String name) {
		this.material_name = name;
	}

	@Override
	public String toString() {
		return  id + "\t\t"  + material_name + "\t" + quantity;
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
		if (quantity != other.quantity)
			return false;
		if (material_name == null) 
			if (other.material_name != null)
				return false;
	    else if (!material_name.equals(other.material_name))
	    	return false;
	
		return true;
	}
	
}
