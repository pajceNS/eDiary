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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.eDiary.entities.enums.ESchoolYear;
import com.eDiary.entities.enums.ESemester;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "subject")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class SubjectEntity {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	@NotNull(message = "Subject name must be specified.")
	@Size(min = 5, max = 30, message = "Subject name must be between {min} and {max} characters long.")
	private String name;
	
	@Column
	@NotNull(message = "Weekly hours must be specified.")
	@Min(value = 0, message = "Weekly hours can't be less than 0.")
	@Max(value = 40, message = "Weekly hours can't be above 40.")
	private Integer weeklyHours;
	
	//@Column
	@NotNull(message = "Year must be specified.")
	@Enumerated(EnumType.STRING)
	private ESchoolYear year;
	
	//@Column
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Semester must be specified.")
	private ESemester semester;
	
	@Column
	private Boolean deleted;
	
	@Version
	private Integer version;	
	
	@JsonIgnore
	@OneToMany(mappedBy = "subject", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<TeacherSubjectEntity> teacherSubject;

	public SubjectEntity() {
		super();
	}

	public SubjectEntity(Integer id,
			@NotNull(message = "Subject name must be specified.") @Size(min = 5, max = 30, message = "Subject name must be between {min} and {max} characters long.") String name,
			@NotNull(message = "Weekly hours must be specified.") @Min(value = 0, message = "Weekly hours can't be less than 0.") @Max(value = 40, message = "Weekly hours can't be above 40.") Integer weeklyHours,
			@NotNull(message = "Year must be specified.") ESchoolYear year,
			@NotNull(message = "Semester must be specified.") ESemester semester, Boolean deleted, Integer version,
			List<TeacherSubjectEntity> teacherSubject) {
		super();
		this.id = id;
		this.name = name;
		this.weeklyHours = weeklyHours;
		this.year = year;
		this.semester = semester;
		this.deleted = deleted;
		this.version = version;
		this.teacherSubject = teacherSubject;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getWeeklyHours() {
		return weeklyHours;
	}

	public void setWeeklyHours(Integer weeklyHours) {
		this.weeklyHours = weeklyHours;
	}

	public ESchoolYear getYear() {
		return year;
	}

	public void setYear(ESchoolYear year) {
		this.year = year;
	}

	public ESemester getSemester() {
		return semester;
	}

	public void setSemester(ESemester semester) {
		this.semester = semester;
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

	public List<TeacherSubjectEntity> getTeacherSubject() {
		return teacherSubject;
	}

	public void setTeacherSubject(List<TeacherSubjectEntity> teacherSubject) {
		this.teacherSubject = teacherSubject;
	}
}