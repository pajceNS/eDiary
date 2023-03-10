package com.eDiary.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.eDiary.entities.dto.SubjectDto;
import com.eDiary.repositories.SubjectRepository;

@Component
public class SubjectValidator implements Validator {

	@Autowired
	private SubjectRepository subjectRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return SubjectDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		SubjectDto subject = (SubjectDto) target;
		if (subjectRepository.existsByNameAndSemesterAndYear(subject.getName(), subject.getSemester(),
				subject.getYear())) {
			errors.reject("400", "name-semester-year for subject is already in use.");
		}
	}

}