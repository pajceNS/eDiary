package com.eDiary.repositories;

import org.springframework.data.repository.CrudRepository;

import com.eDiary.entities.RoleEntity;

public interface RoleRepository extends CrudRepository<RoleEntity, Integer> {
	RoleEntity findByName(String name);
}
