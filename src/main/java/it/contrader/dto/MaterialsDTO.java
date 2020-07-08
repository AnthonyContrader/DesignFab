package it.contrader.dto;

public class MaterialsDTO {
	private int id;
	private String material_name;
	private double quantity_materials;
	
	public MaterialsDTO() {
	}

	public MaterialsDTO(String material_name) {
		this.material_name=material_name;
	}
	public MaterialsDTO (String material_name,double quantity_materials) {
		this.quantity_materials=quantity_materials;
		this.material_name=material_name;
	}
	
	public MaterialsDTO (String material_name,int id) {
		this.id=id;
		this.material_name=material_name;
	}

	public MaterialsDTO (String material_name, double quantity_materials, int id) {
		this.quantity_materials=quantity_materials;
		this.id=id;
		this.material_name=material_name;
	}
	
	public int getId() {
		return id;
	}
	public double getQuantity() {
		return quantity_materials;
	}

	public void setQuantity(double quantity_materials) {
		this.quantity_materials = quantity_materials;
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
		return  id + "\t"  + material_name + "\t" + quantity_materials;}
	

}
