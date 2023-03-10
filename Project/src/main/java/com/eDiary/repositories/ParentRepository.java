package com.eDiary.repositories;

import org.springframework.data.repository.CrudRepository;

import com.eDiary.entities.ParentEntity;

public interface ParentRepository extends CrudRepository<ParentEntity, Integer> {
	
}
