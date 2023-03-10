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
@Table(name = "TeacherSubject")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class TeacherSubjectEntity {

	@Id
	@GeneratedValue
	private Integer id;

	@Column
	private Boolean deleted;

	@Version
	private Integer version;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "subject")
	private SubjectEntity subject;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "teacher")
	private TeacherEntity teacher;

	@JsonIgnore
	@OneToMany(mappedBy = "teacherSubject", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<StudentTeacherSubjectEntity> studentTeacherSubject;

	public TeacherSubjectEntity() {
		super();
	}

	public TeacherSubjectEntity(Integer id, Boolean deleted, Integer version, SubjectEntity subject,
			TeacherEntity teacher, List<StudentTeacherSubjectEntity> studentTeacherSubject) {
		super();
		this.id = id;
		this.deleted = deleted;
		this.version = version;
		this.subject = subject;
		this.teacher = teacher;
		this.studentTeacherSubject = studentTeacherSubject;
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

	public SubjectEntity getSubject() {
		return subject;
	}

	public void setSubject(SubjectEntity subject) {
		this.subject = subject;
	}

	public TeacherEntity getTeacher() {
		return teacher;
	}

	public void setTeacher(TeacherEntity teacher) {
		this.teacher = teacher;
	}

	public List<StudentTeacherSubjectEntity> getStudentTeacherSubject() {
		return studentTeacherSubject;
	}

	public void setStudentTeacherSubject(List<StudentTeacherSubjectEntity> studentTeacherSubject) {
		this.studentTeacherSubject = studentTeacherSubject;
	}
}
