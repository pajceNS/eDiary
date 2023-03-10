package com.eDiary.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.eDiary.entities.dto.ParentDto;

@Component
public class ParentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ParentDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ParentDto parent = (ParentDto) target;
		if (parent.getPassword() != null && !parent.getPassword().equals(parent.getConfirmedPassword())) {
			errors.reject("400", "Passwords must match.");
		}
	}

}
