package com.juliechan.dojosninjas.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.juliechan.dojosninjas.models.Ninja;

public interface NinjaRepo extends CrudRepository<Ninja, Long>{
	// ALL NINJAS
	List<Ninja> findAll();
	
	// ALL NINJAS UNDER ONE DOJO
	Optional<Ninja> findById(Long dojoId);
}
