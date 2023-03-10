package com.eDiary.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eDiary.entities.StudentEntity;
import com.eDiary.repositories.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public boolean isActive(Integer studentId) {
		if (studentRepository.existsById(studentId)) {
			StudentEntity student = studentRepository.findById(studentId).get();
			if (student.getDeleted().equals(true)) {
				return false;
			}
			return true;
		}
		return false;
	}

}
