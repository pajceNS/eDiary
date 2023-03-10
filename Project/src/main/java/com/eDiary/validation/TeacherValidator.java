package com.eDiary.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.eDiary.entities.dto.TeacherDto;

@Component
public class TeacherValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return TeacherDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		TeacherDto teacher = (TeacherDto) target;

		if (teacher.getPassword() != null && !teacher.getPassword().equals(teacher.getConfirmedPassword())) {
			errors.reject("400", "Password must match.");
		}
	}

}
