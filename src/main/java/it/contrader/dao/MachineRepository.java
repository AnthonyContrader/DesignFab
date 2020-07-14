package it.contrader.dao;


import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Machine;


@Repository
@Transactional
public interface MachineRepository extends CrudRepository<Machine, Long>{


		

}
