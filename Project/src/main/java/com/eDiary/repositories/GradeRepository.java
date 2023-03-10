package com.eDiary.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.eDiary.entities.GradeEntity;
import com.eDiary.entities.StudentTeacherSubjectEntity;

public interface GradeRepository extends CrudRepository<GradeEntity, Integer> {

	List<GradeEntity> findByStudentTeacherSubject(StudentTeacherSubjectEntity stse);
	
}
