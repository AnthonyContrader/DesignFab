package it.contrader.converter;
import java.util.ArrayList;
import java.util.List;
import it.contrader.dto.MaterialsDTO;
import it.contrader.model.Materials;

public class MaterialsConverter implements Converter<Materials, MaterialsDTO> {

	@Override
	public MaterialsDTO toDTO(Materials entity) {
		MaterialsDTO materialsDTO = new MaterialsDTO(entity.getMaterial_name(), entity.getQuantity(), entity.getId());
		return materialsDTO;
	}

	@Override
	public Materials toEntity(MaterialsDTO dto) {
		Materials materials = new Materials(dto.getMaterialName(), dto.getQuantity(), dto.getId());
		return materials;
	}

	@Override
	public List<MaterialsDTO> toDTOList(List<Materials> entityList) {
		List<MaterialsDTO> userDTOList = new ArrayList<MaterialsDTO>();

		for (Materials material : entityList) {
			userDTOList.add(toDTO(material));
		}
		return userDTOList;
	}

}
