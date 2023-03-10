package com.eDiary.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eDiary.entities.ClassEntity;
import com.eDiary.repositories.ClassRepository;

@Service
public class ClassServiceImpl implements ClassService {

	@Autowired
	private ClassRepository classRepository;

	@Override
	public Boolean isActive(Integer id) {
		if (classRepository.existsById(id)) {
			ClassEntity clazz = classRepository.findById(id).get();
			if (clazz.getDeleted().equals(true)) {
				return false;
			}
			return true;
		}
		return false;
	}

}
