package com.juliechan.dojosninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juliechan.dojosninjas.models.Ninja;
import com.juliechan.dojosninjas.repositories.NinjaRepo;

@Service
public class NinjaService {
	// CONNECTING NINJA REPO
	@Autowired
	private NinjaRepo nRepo; 
	
	// ALL NINJAS
	public List<Ninja> getAll() {
		return nRepo.findAll();
	}
	
	// CREATE OR UPDATE NINJA
	public Ninja createOrUpdate(Ninja n) {
		return nRepo.save(n);
	}
	
	// DELETE NINJA
	public void deleteById(Long id) {
		nRepo.deleteById(id);
	}

}
