package it.contrader.dto;

public class MaterialsDTO {
	private int id;
	private String material_name;
	private double quantity;
	
	public MaterialsDTO() {
	}

	public MaterialsDTO(String material_name) {
		this.material_name=material_name;
	}
	public MaterialsDTO (String material_name,double quantity) {
		this.quantity=quantity;
		this.material_name=material_name;
	}
	
	public MaterialsDTO (String material_name,int id) {
		this.id=id;
		this.material_name=material_name;
	}

	public MaterialsDTO (String material_name, double quantity, int id) {
		this.quantity=quantity;
		this.id=id;
		this.material_name=material_name;
	}
	
	public int getId() {
		return id;
	}
	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getMaterialName() {
		return material_name;
	}
	public void setMaterialName(String material_name) {
		this.material_name=material_name;
	}
	
	@Override
	public String toString() {
		return  id + "\t"  + material_name + "\t" + quantity;}
	

}
