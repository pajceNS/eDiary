package com.eDiary.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eDiary.entities.ParentEntity;
import com.eDiary.repositories.ParentRepository;

@Service
public class ParentServiceImpl implements ParentService {

	@Autowired
	private ParentRepository parentRepository;

	@Override
	public boolean isActive(Integer id) {
		if (parentRepository.existsById(id)) {
			ParentEntity clazz = parentRepository.findById(id).get();
			if (clazz.getDeleted().equals(true)) {
				return false;
			}
			return true;
		}
		return false;
	}
}
