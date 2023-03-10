package com.eDiary.repositories;

import org.springframework.data.repository.CrudRepository;

import com.eDiary.entities.StudentEntity;
import com.eDiary.entities.StudentTeacherSubjectEntity;
import com.eDiary.entities.TeacherSubjectEntity;

public interface StudentTeacherSubjectRepository extends CrudRepository<StudentTeacherSubjectEntity, Integer> {

	Boolean existsByStudentAndTeacherSubject(StudentEntity studentEntity, TeacherSubjectEntity teacherSubject);

	StudentTeacherSubjectEntity findByStudentAndTeacherSubject(StudentEntity student,
			TeacherSubjectEntity teacherSubject);

}
