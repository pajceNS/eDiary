package com.eDiary.repositories;

import org.springframework.data.repository.CrudRepository;

import com.eDiary.entities.SubjectEntity;
import com.eDiary.entities.enums.ESchoolYear;
import com.eDiary.entities.enums.ESemester;

public interface SubjectRepository extends CrudRepository<SubjectEntity, Integer> {

	Boolean existsByNameAndSemesterAndYear(String name, ESemester semester, ESchoolYear year);

}
