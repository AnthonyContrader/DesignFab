package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.MachinesDTO;
import it.contrader.dto.SensorDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Machines;
import it.contrader.model.Sensor;
import it.contrader.model.User;

public class MachinesConverter implements Converter<Machines, MachinesDTO>{

	@Override
	public MachinesDTO toDTO(Machines entity) {
		MachinesDTO sensorDTO = new MachinesDTO(entity.getId(), entity.getModel(), entity.getInit_quantity(), entity.getFinal_quantity());
		return sensorDTO;
	}

	@Override
	public Machines toEntity(MachinesDTO dto) {
		Machines machine = new Machines(dto.getId(), dto.getModel(), dto.getInit_quantity(), dto.getFinal_quantity());
		return machine;
	}

	@Override
	public List<MachinesDTO> toDTOList(List<Machines> entityList) {

		List<MachinesDTO> machineDTOList = new ArrayList<MachinesDTO>();
		
		for (Machines machine : entityList) {
			machineDTOList.add(toDTO(machine));
		}
		return machineDTOList;
	}
	
}
