package it.contrader.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Sensor;

@Repository //
@Transactional //
public interface SensorRepository extends CrudRepository<Sensor, Long> {
	
}
