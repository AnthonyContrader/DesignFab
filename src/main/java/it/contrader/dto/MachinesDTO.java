package it.contrader.dto;

public class MachinesDTO{
	private int id;
	private String model;
	private double init_quantity;
	private double final_quantity;
	
	public MachinesDTO (String model, double init_quantity, double final_quantity) {
		this.model = model;
		this.init_quantity = init_quantity;
		this.final_quantity = final_quantity;
	}

	public MachinesDTO (int id, String model, double init_quantity, double final_quantity) {
		this.id = id;
		this.model = model;
		this.init_quantity = init_quantity;
		this.final_quantity = final_quantity;
	}
	
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getModel() {
		return this.model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	public double getInit_quantity() {
		return this.init_quantity;
	}
	public void setInit_quantity(double init_quantity) {
		this.init_quantity = init_quantity;
	}
	public double getFinal_quantity() {
		return this.final_quantity;
	}
	public void setFinal_quantity(double final_quantity) {
		this.final_quantity = final_quantity;
	}
	
	@Override
	public String toString() {
		return  id + "\t"  + model + "\t\t" + init_quantity + "\t\t" + final_quantity;
	}
}
	
		
	
	
	