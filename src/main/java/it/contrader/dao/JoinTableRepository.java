package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Machine;
import it.contrader.model.Materials;

@Repository
@Transactional
public interface JoinTableRepository extends CrudRepository<Machine, Materials> {

	
	
}
