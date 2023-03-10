package com.eDiary.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eDiary.entities.SubjectEntity;
import com.eDiary.repositories.SubjectRepository;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectRepository subjectRepository;

	@Override
	public boolean isActive(Integer id) {
		if (subjectRepository.existsById(id)) {
			SubjectEntity clazz = subjectRepository.findById(id).get();
			if (clazz.getDeleted().equals(true)) {
				return false;
			}
			return true;
		}
		return false;
	}

}
