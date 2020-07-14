package it.contrader.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Materials;

@Repository
@Transactional
public interface MaterialsRepository extends CrudRepository<Materials, Long> {
	
	List<Materials> findAllByMaterialsQuantity(int quantity);
}


