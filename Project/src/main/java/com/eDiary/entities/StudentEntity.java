package com.eDiary.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "student")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class StudentEntity extends UserEntity {

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "attendingClass")
	private ClassEntity attendingClass;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "parent")
	private ParentEntity parent;

	@JsonIgnore
	@OneToMany(mappedBy = "student", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<StudentTeacherSubjectEntity> studentTeacherSubject;

	public StudentEntity() {
		super();
	}

	public StudentEntity(ClassEntity attendingClass, ParentEntity parent,
			List<StudentTeacherSubjectEntity> studentTeacherSubject) {
		super();
		this.attendingClass = attendingClass;
		this.parent = parent;
		this.studentTeacherSubject = studentTeacherSubject;
	}

	public ClassEntity getAttendingClass() {
		return attendingClass;
	}

	public void setAttendingClass(ClassEntity attendingClass) {
		this.attendingClass = attendingClass;
	}

	public ParentEntity getParent() {
		return parent;
	}

	public void setParent(ParentEntity parent) {
		this.parent = parent;
	}

	public List<StudentTeacherSubjectEntity> getStudentTeacherSubject() {
		return studentTeacherSubject;
	}

	public void setStudentTeacherSubject(List<StudentTeacherSubjectEntity> studentTeacherSubject) {
		this.studentTeacherSubject = studentTeacherSubject;
	}
}