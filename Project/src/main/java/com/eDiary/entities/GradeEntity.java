package com.eDiary.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import com.eDiary.entities.enums.EGradeType;
import com.eDiary.entities.enums.EGradeValue;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "grade")
public class GradeEntity {

	@Id
	@GeneratedValue
	private Integer id;

	@Enumerated(EnumType.STRING)
	@NotNull(message = "Grade value must be specified.")
	private EGradeValue value;

	@Enumerated(EnumType.STRING)
	@NotNull(message = "Grade type must be specified.")
	private EGradeType type;

	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy")
	private LocalDate date;

	@Column
	private Boolean finalGrade;

	@Column
	private Boolean deleted;

	@Version
	private Integer version;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "studentTeacherSubject")
	private StudentTeacherSubjectEntity studentTeacherSubject;

	public GradeEntity() {
		super();
	}

	public GradeEntity(Integer id, @NotNull(message = "Grade value must be specified.") EGradeValue value,
			@NotNull(message = "Grade type must be specified.") EGradeType type, LocalDate date, Boolean finalGrade,
			Boolean deleted, Integer version, StudentTeacherSubjectEntity studentTeacherSubject) {
		super();
		this.id = id;
		this.value = value;
		this.type = type;
		this.date = date;
		this.finalGrade = finalGrade;
		this.deleted = deleted;
		this.version = version;
		this.studentTeacherSubject = studentTeacherSubject;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EGradeValue getValue() {
		return value;
	}

	public void setValue(EGradeValue value) {
		this.value = value;
	}

	public EGradeType getType() {
		return type;
	}

	public void setType(EGradeType type) {
		this.type = type;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Boolean getFinalGrade() {
		return finalGrade;
	}

	public void setFinalGrade(Boolean finalGrade) {
		this.finalGrade = finalGrade;
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

	public StudentTeacherSubjectEntity getStudentTeacherSubject() {
		return studentTeacherSubject;
	}

	public void setStudentTeacherSubject(StudentTeacherSubjectEntity studentTeacherSubject) {
		this.studentTeacherSubject = studentTeacherSubject;
	}
}