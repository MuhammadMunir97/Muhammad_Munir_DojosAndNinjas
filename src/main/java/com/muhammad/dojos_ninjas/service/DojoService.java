package com.muhammad.dojos_ninjas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.muhammad.dojos_ninjas.modell.Dojo;
import com.muhammad.dojos_ninjas.repositories.DojoRepository;

@Service
public class DojoService {
	
	private final DojoRepository dojoRepository;

	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	public List<Dojo> findAll(){
		return dojoRepository.findAll();
	}
	
	public Dojo findById(Long id) {
		Optional<Dojo> dojo = dojoRepository.findById(id);
		if(dojo.isPresent()) {
			return dojo.get();
		}else {
			return null;
		}
	}
	
	public void saveDojo(Dojo dojo) {
		dojoRepository.save(dojo);
	}
	
	public void deleteDojoById(Long id) {
		dojoRepository.deleteById(id);
	}
}
