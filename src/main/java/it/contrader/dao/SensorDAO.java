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
public interface SensorDAO extends CrudRepository<Sensor, Long> {
	String hql = "Select m.machine_name from Machine as m, Sensor as s where m.id_machine = s.id_machine";
}
