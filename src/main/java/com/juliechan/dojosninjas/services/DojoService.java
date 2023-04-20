package com.juliechan.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juliechan.dojosninjas.models.Dojo;
import com.juliechan.dojosninjas.repositories.DojoRepo;

@Service
public class DojoService {
	// CONNECTING DOJO REPO
	@Autowired
	private DojoRepo dRepo;
	
	// ALL DOJOS
	public List<Dojo> getAll() {
		return dRepo.findAll();
	}
	
	// ONE DOJO
	public Dojo getOne(Long id) {
		Optional<Dojo> d = dRepo.findById(id);
		if(d.isPresent()) {
			return d.get();
		}
		return null;
	}
	
	// CREATE OR UPDATE DOJO
	public Dojo createOrUpdate(Dojo d) {
		return dRepo.save(d);
	}
	
	// DELETE DOJO
	public void deleteById(Long id) {
		dRepo.deleteById(id);
	}
	
}
