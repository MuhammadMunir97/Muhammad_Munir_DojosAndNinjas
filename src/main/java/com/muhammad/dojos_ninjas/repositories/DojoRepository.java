package com.muhammad.dojos_ninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.muhammad.dojos_ninjas.modell.Dojo;


public interface DojoRepository extends CrudRepository<Dojo, Long>{
	public List<Dojo> findAll();
}
