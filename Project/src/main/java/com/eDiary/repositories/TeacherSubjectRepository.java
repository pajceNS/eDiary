package com.eDiary.repositories;

import org.springframework.data.repository.CrudRepository;

import com.eDiary.entities.SubjectEntity;
import com.eDiary.entities.TeacherEntity;
import com.eDiary.entities.TeacherSubjectEntity;

public interface TeacherSubjectRepository extends CrudRepository<TeacherSubjectEntity, Integer> {

	Boolean existsByTeacherAndSubject(TeacherEntity teacher, SubjectEntity subject);

	TeacherSubjectEntity findByTeacherAndSubject(TeacherEntity teacher, SubjectEntity subject);

}
