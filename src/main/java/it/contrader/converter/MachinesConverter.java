package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.MachinesDTO;
import it.contrader.model.Machines;

public class MachinesConverter {
	public MachinesDTO toDTO(Machines machines) {

		MachinesDTO machinesDTO = new MachinesDTO(machines.getId(), machines.getModel(),machines.getInit_quantity(),machines.getFinal_quantity());
		return machinesDTO;

	}
	
	
	public Machines toEntity(MachinesDTO machinesDTO) {

		Machines machines = new Machines(machinesDTO.getId(), machinesDTO.getModel(),machinesDTO.getInit_quantity(),machinesDTO.getFinal_quantity());
		return machines;

	}
	
	public Machines toEntityInsert(MachinesDTO machinesDTO) {

		Machines machines = new Machines(machinesDTO.getModel(),machinesDTO.getInit_quantity(),machinesDTO.getFinal_quantity());
		return machines;

	}

	

	public List<MachinesDTO> toDTOList(List<Machines> machinesList) {

		List<MachinesDTO> machinesDTOList = new ArrayList<MachinesDTO>();

		for (Machines machine : machinesList) {

			machinesDTOList.add(toDTO(machine));
		}
		return machinesDTOList;
	}
}
