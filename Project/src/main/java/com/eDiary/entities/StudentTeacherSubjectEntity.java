package com.eDiary.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "StudentTeacherSubject")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class StudentTeacherSubjectEntity {

	@Id
	@GeneratedValue
	private Integer id;

	@Column
	private Boolean deleted;

	@Version
	private Integer version;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "student")
	private StudentEntity student;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "teacherSubject")
	private TeacherSubjectEntity teacherSubject;

	@JsonIgnore
	@OneToMany(mappedBy = "studentTeacherSubject", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<GradeEntity> grades;

	public StudentTeacherSubjectEntity() {
		super();
	}

	public StudentTeacherSubjectEntity(Integer id, Boolean deleted, Integer version, StudentEntity student,
			TeacherSubjectEntity teacherSubject, List<GradeEntity> grades) {
		super();
		this.id = id;
		this.deleted = deleted;
		this.version = version;
		this.student = student;
		this.teacherSubject = teacherSubject;
		this.grades = grades;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public StudentEntity getStudent() {
		return student;
	}

	public void setStudent(StudentEntity student) {
		this.student = student;
	}

	public TeacherSubjectEntity getTeacherSubject() {
		return teacherSubject;
	}

	public void setTeacherSubject(TeacherSubjectEntity teacherSubject) {
		this.teacherSubject = teacherSubject;
	}

	public List<GradeEntity> getGrades() {
		return grades;
	}

	public void setGrades(List<GradeEntity> grades) {
		this.grades = grades;
	}
}
