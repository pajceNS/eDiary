package com.eDiary.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "teacher")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class TeacherEntity extends UserEntity {

	@JsonIgnore
	@OneToOne(mappedBy = "supervisorTeacher", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private ClassEntity supervisesClass;

	@JsonIgnore
	@OneToMany(mappedBy = "teacher", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<TeacherSubjectEntity> teacherSubject;

	public TeacherEntity() {
		super();
	}
	
	public TeacherEntity(ClassEntity supervisesClass, List<TeacherSubjectEntity> teacherSubject) {
		super();
		this.supervisesClass = supervisesClass;
		this.teacherSubject = teacherSubject;
	}

	public ClassEntity getSupervisesClass() {
		return supervisesClass;
	}

	public void setSupervisesClass(ClassEntity supervisesClass) {
		this.supervisesClass = supervisesClass;
	}

	public List<TeacherSubjectEntity> getTeacherSubject() {
		return teacherSubject;
	}

	public void setTeacherSubject(List<TeacherSubjectEntity> teacherSubject) {
		this.teacherSubject = teacherSubject;
	}
}
