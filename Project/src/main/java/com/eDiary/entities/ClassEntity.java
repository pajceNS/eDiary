package com.eDiary.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.eDiary.entities.enums.ESchoolYear;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "class")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ClassEntity {

	@Id
	@GeneratedValue
	private Integer id;

	@Column
	@NotNull(message = "Class number must be specified.")
	@Pattern(regexp = "^[1-9{n}]$", message = "Class number must be in range of 1-9.")
	private String classNumber;

	@Enumerated(EnumType.STRING)
	@NotNull(message = "Year must be specified.")
	private ESchoolYear year;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "supervisorTeacher")
	private TeacherEntity supervisorTeacher;

	@JsonIgnore
	@OneToMany(mappedBy = "attendingClass", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<StudentEntity> students;

	@Column
	private Boolean deleted;

	@Version
	private Integer version;

	public ClassEntity() {
		super();
	}

	public ClassEntity(Integer id,
			@NotNull(message = "Class number must be specified.") @Pattern(regexp = "^[1-9{n}]$", message = "Class number must be in range of 1-9.") String classNumber,
			@NotNull(message = "Year must be specified.") ESchoolYear year, TeacherEntity supervisorTeacher,
			List<StudentEntity> students, Boolean deleted, Integer version) {
		super();
		this.id = id;
		this.classNumber = classNumber;
		this.year = year;
		this.supervisorTeacher = supervisorTeacher;
		this.students = students;
		this.deleted = deleted;
		this.version = version;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClassNumber() {
		return classNumber;
	}

	public void setClassNumber(String classNumber) {
		this.classNumber = classNumber;
	}

	public ESchoolYear getYear() {
		return year;
	}

	public void setYear(ESchoolYear year) {
		this.year = year;
	}

	public TeacherEntity getSupervisorTeacher() {
		return supervisorTeacher;
	}

	public void setSupervisorTeacher(TeacherEntity supervisorTeacher) {
		this.supervisorTeacher = supervisorTeacher;
	}

	public List<StudentEntity> getStudents() {
		return students;
	}

	public void setStudents(List<StudentEntity> students) {
		this.students = students;
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
}
