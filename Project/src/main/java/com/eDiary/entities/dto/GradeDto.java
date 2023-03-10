package com.eDiary.entities.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import com.eDiary.entities.enums.EGradeType;
import com.eDiary.entities.enums.EGradeValue;

public class GradeDto {

	@Enumerated(EnumType.STRING)
	@NotNull(message = "Grade value must be specified.")
	private EGradeValue value;

	@Enumerated(EnumType.STRING)
	@NotNull(message = "Grade type must be specified.")
	private EGradeType type;

	public GradeDto() {
		super();
	}

	public GradeDto(@NotNull(message = "Grade value must be specified.") EGradeValue value,
			@NotNull(message = "Grade type must be specified.") EGradeType type) {
		super();
		this.value = value;
		this.type = type;
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
}
