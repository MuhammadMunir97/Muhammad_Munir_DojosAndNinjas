package com.muhammad.dojos_ninjas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.muhammad.dojos_ninjas.modell.Ninja;
import com.muhammad.dojos_ninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	private final NinjaRepository ninjaRepository;

	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	public List<Ninja> findAll(){
		return ninjaRepository.findAll();
	}
	
	public Ninja findById(Long id) {
		Optional<Ninja> ninja = ninjaRepository.findById(id);
		if(ninja.isPresent()) {
			return ninja.get();
		}else {
			return null;
		}
	}
	
	public List<Ninja> findByDojoID(Long id){
		return ninjaRepository.findByDojoId(id);
	}
	
	public void saveNinja (Ninja ninja) {
		ninjaRepository.save(ninja);
	}
	
	public void deleteNinjaById (Long id) {
		ninjaRepository.deleteById(id);
	}
}
