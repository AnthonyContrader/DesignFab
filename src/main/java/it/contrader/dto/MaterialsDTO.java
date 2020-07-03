package it.contrader.dto;

public class MaterialsDTO {
	private int id;
	private String material_name;

	public MaterialsDTO() {
	}

	public MaterialsDTO(String material_name) {
		this.material_name=material_name;
	}
	public MaterialsDTO (String material_name,int id) {
		this.id=id;
		this.material_name=material_name;
	}

	public int getid() {
		return id;
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
		return  id + "\t"  + material_name;}
	

}
