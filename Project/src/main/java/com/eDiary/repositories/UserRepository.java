package com.eDiary.repositories;

import org.springframework.data.repository.CrudRepository;

import com.eDiary.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

}
