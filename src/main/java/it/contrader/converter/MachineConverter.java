package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.MachineDTO;
import it.contrader.model.Machine;
import it.contrader.model.Sensor;

@Component
public class MachineConverter extends AbstractConverter<Machine, MachineDTO> {

	@Override
	public Machine toEntity(MachineDTO machineDTO) {
		Machine machine = null;
		if (machineDTO != null) {
			machine = new Machine(machineDTO.getId_machine(), machineDTO.getMachineName(),
					machineDTO.getMaterialName(),  machineDTO.getSensor()/*, machineDTO.getMaterialsOnMachine()*/);

		}
		return machine;
	}

	@Override
	public MachineDTO toDTO(Machine machineEntity) {
		MachineDTO machineDTO = null;
		if (machineEntity != null) {
			machineDTO = new MachineDTO(machineEntity.getId_machine(), machineEntity.getMachine_name(),
					machineEntity.getMaterialName(), machineEntity.getSensor()/*, machineEntity.getMaterialsOnMachine()*/);
		}

		return machineDTO;
	}

}
