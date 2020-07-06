package it.contrader.model;

public class Machines {

	private int id;

	private String model;

	private double init_quantity;

	private double final_quantity;

	public Machines() {
	}

	public Machines( String model, double init_quantity, double final_quantity) {
		this.setModel(model);
		this.setInit_quantity(init_quantity);
		this.setFinal_quantity(final_quantity);
	}
	
	public Machines(int id, String model, double init_quantity, double final_quantity) {
		this.setId(id);
		this.setModel(model);
		this.setInit_quantity(init_quantity);
		this.setFinal_quantity(final_quantity);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getInit_quantity() {
		return init_quantity;
	}

	public void setInit_quantity(double init_quantity) {
		this.init_quantity = init_quantity;
	}

	public double getFinal_quantity() {
		return final_quantity;
	}

	public void setFinal_quantity(double final_quantity) {
		this.final_quantity = final_quantity;
	}

	
	@Override
	public String toString() {
		return  id + "\t"  + model +"\t\t" +   init_quantity + "\t\t" + final_quantity;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Machines other = (Machines) obj;
		if (id != other.id)
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (init_quantity != other.init_quantity) {
			return false;
		}
		if (final_quantity != other.final_quantity) {
			return false;
		}
		return true;
	}

}
