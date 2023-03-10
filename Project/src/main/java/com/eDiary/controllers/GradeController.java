package com.eDiary.controllers;

import java.util.List;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eDiary.entities.GradeEntity;
import com.eDiary.entities.dto.GradeDto;
import com.eDiary.entities.util.RESTError;
import com.eDiary.repositories.GradeRepository;

@RestController
@RequestMapping(value = "/api/v1/grades")
public class GradeController {

	private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private GradeRepository gradeRepository;

	// get all
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAll() {
		try {
			return new ResponseEntity<>((List<GradeEntity>) gradeRepository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<RESTError>(new RESTError(1, "Internal server error."),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// get by id
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id) {
		if (gradeRepository.existsById(id)) {
			return new ResponseEntity<GradeEntity>(gradeRepository.findById(id).get(), HttpStatus.OK);
		}
		return new ResponseEntity<RESTError>(new RESTError(2, "Grade not found."), HttpStatus.NOT_FOUND);
	}

	// add new grade
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addGrade(@Valid @RequestBody GradeDto newGrade) {
		GradeEntity grade = new GradeEntity();
		grade.setDeleted(false);
		grade.setType(newGrade.getType());
		grade.setValue(newGrade.getValue());
		gradeRepository.save(grade);
		logger.info("Added grade: " + grade.toString());
		return new ResponseEntity<GradeEntity>(grade, HttpStatus.OK);

	}

	// delete grade
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Integer id) {
		if (gradeRepository.existsById(id)) {
			GradeEntity grade = new GradeEntity();
			grade.setDeleted(true);
			gradeRepository.save(grade);
			logger.info("Deleted grade: " + grade.toString());
			return new ResponseEntity<GradeEntity>(grade, HttpStatus.OK);
		}
		return new ResponseEntity<RESTError>(new RESTError(4, "Grade not found."), HttpStatus.NOT_FOUND);
	}
}
