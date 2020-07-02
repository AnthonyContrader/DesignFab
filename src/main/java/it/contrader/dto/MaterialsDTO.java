package it.contrader.dto;

public class MaterialsDTO {
	private int id;
	private String MaterialName;

	public MaterialsDTO() {
	}

	public MaterialsDTO(String MaterialName) {
		this.MaterialName=MaterialName;
	}
	public MaterialsDTO (int id, String MaterialName) {
		this.id=id;
		this.MaterialName=MaterialName;
	}

	public int getid() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMaterialName() {
		return MaterialName;
	}
	public void setMaterialName(String MaterialName) {
		this.MaterialName=MaterialName;
	}
	
	@Override
	public String toString() {
		return  id + "\t"  + MaterialName;}
	

}
