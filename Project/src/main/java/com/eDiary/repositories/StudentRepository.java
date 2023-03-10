package com.eDiary.repositories;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.eDiary.entities.ClassEntity;
import com.eDiary.entities.StudentEntity;

public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {

	Boolean existsByAttendingClass(ClassEntity classEntity);

	Collection<StudentEntity> findByAttendingClass(ClassEntity classEntity);
	
}
