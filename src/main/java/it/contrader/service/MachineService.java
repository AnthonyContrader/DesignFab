package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.MachineConverter;
import it.contrader.dao.MachineRepository;
import it.contrader.dto.MachineDTO;
import it.contrader.model.Machine;

@Service
public class MachineService extends AbstractService<Machine, MachineDTO> {

	@Autowired
	private MachineConverter converter;
	@Autowired
	private MachineRepository repository;



}
