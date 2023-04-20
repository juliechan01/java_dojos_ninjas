package com.juliechan.dojosninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.juliechan.dojosninjas.models.Dojo;

public interface DojoRepo extends CrudRepository<Dojo, Long>{
	// ALL DOJO LOCATIONS
	List<Dojo> findAll();
}
