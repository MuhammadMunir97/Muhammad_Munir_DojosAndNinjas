package com.muhammad.dojos_ninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.muhammad.dojos_ninjas.modell.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja, Long> {

	public List<Ninja> findAll();
	// extra functionality to access all ninjas in a dojo from the ninjas table
	public List<Ninja> findByDojoId(Long id);
}
