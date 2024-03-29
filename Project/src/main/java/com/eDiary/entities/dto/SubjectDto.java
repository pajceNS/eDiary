package com.eDiary.entities.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.eDiary.entities.enums.ESchoolYear;
import com.eDiary.entities.enums.ESemester;

public class SubjectDto {

	@NotNull(message = "Course name must be specified.")
	@Size(min = 5, max = 30, message = "Subject name must be between {min} and {max} characters long.")
	@Pattern(regexp = "^[a-zA-Z0-9\\s,]*$", message = "Invalid subject name.")
	private String name;

	@NotNull(message = "Weekly hours must be specified.")
	@Min(value = 0, message = "Weekly hours can't be less than 0.")
	@Max(value = 40, message = "Weekly hours can't be above 40.")
	private Integer weeklyHours;

	@NotNull(message = "Year must be specified.")
	@Enumerated(EnumType.STRING)
	private ESchoolYear year;

	@Enumerated(EnumType.STRING)
	@NotNull(message = "Semester must be specified.")
	private ESemester semester;

	public SubjectDto() {
		super();
	}

	public SubjectDto(
			@NotNull(message = "Course name must be specified.") @Size(min = 5, max = 30, message = "Subject name must be between {min} and {max} characters long.") @Pattern(regexp = "^[a-zA-Z0-9\\s,]*$", message = "Invalid subject name.") String name,
			@NotNull(message = "Weekly hours must be specified.") @Min(value = 0, message = "Weekly hours can't be less than 0.") @Max(value = 40, message = "Weekly hours can't be above 40.") Integer weeklyHours,
			@NotNull(message = "Year must be specified.") ESchoolYear year,
			@NotNull(message = "Semester must be specified.") ESemester semester) {
		super();
		this.name = name;
		this.weeklyHours = weeklyHours;
		this.year = year;
		this.semester = semester;
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
}
