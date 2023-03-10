package com.eDiary.repositories;

import org.springframework.data.repository.CrudRepository;

import com.eDiary.entities.TeacherEntity;

public interface TeacherRepository extends CrudRepository<TeacherEntity, Integer> {

}
