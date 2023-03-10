package com.eDiary.repositories;

import org.springframework.data.repository.CrudRepository;

import com.eDiary.entities.ClassEntity;
import com.eDiary.entities.enums.ESchoolYear;

public interface ClassRepository extends CrudRepository<ClassEntity, Integer> {

	Boolean existsByClassNumberAndYear(String classNumber, ESchoolYear year);
	
}
