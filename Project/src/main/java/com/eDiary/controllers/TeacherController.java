package com.eDiary.controllers;

import java.util.List;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eDiary.entities.TeacherEntity;
import com.eDiary.entities.dto.TeacherDto;
import com.eDiary.entities.util.RESTError;
import com.eDiary.repositories.RoleRepository;
import com.eDiary.repositories.TeacherRepository;
import com.eDiary.services.TeacherService;
import com.eDiary.validation.TeacherValidator;

@RestController
@RequestMapping(value = "/api/v1/teachers")
public class TeacherController {

	private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

	@Autowired
	private TeacherRepository teacherRepository;

	@Autowired
	private TeacherService teacherService;

	@Autowired
	private TeacherValidator teacherValidator;

	@Autowired
	private RoleRepository roleRepository;

	@InitBinder
	protected void initBinder(final WebDataBinder binder) {
		binder.addValidators(teacherValidator);
	}

	// get all
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAll() {
		try {
			return new ResponseEntity<>((List<TeacherEntity>) teacherRepository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<RESTError>(new RESTError(1, "Internal server error."),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// get by id
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id) {
		TeacherEntity teacher = teacherRepository.findById(id).get();
		if (teacherRepository.existsById(id)) {
			return new ResponseEntity<TeacherEntity>(teacher, HttpStatus.OK);
		}
		return new ResponseEntity<RESTError>(new RESTError(2, "Teacher not found."), HttpStatus.NOT_FOUND);
	}

	// add new teacher
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addNewTeacher(@Valid @RequestBody TeacherDto newTeacher, BindingResult result) {
		if (result.hasErrors()) {
			return new ResponseEntity<>(createErrorMessage(result), HttpStatus.BAD_REQUEST);
		} else {
			teacherValidator.validate(newTeacher, result);
		}
		TeacherEntity teacher = new TeacherEntity();
		teacher.setDeleted(false);
		teacher.setFirstName(newTeacher.getFirstName());
		teacher.setLastName(newTeacher.getLastName());
		teacher.setUsername(newTeacher.getUsername());
		teacher.setPassword(newTeacher.getPassword());
		teacher.setRole(roleRepository.findById(2).get());
		teacherRepository.save(teacher);
		logger.info("Added teacher: " + newTeacher.toString());
		return new ResponseEntity<TeacherEntity>(teacher, HttpStatus.OK);
	}

	// update teacher
	@RequestMapping(method = RequestMethod.PUT, value = "/{teacherId}")
	public ResponseEntity<?> updateTeacher(@PathVariable Integer teacherId, @Valid @RequestBody TeacherDto uteacher,
			BindingResult result) {
		if (teacherRepository.existsById(teacherId) && teacherService.isActive(teacherId)) {
			if (result.hasErrors()) {
				return new ResponseEntity<>(createErrorMessage(result), HttpStatus.BAD_REQUEST);
			}
			TeacherEntity teacher = teacherRepository.findById(teacherId).get();
			teacher.setFirstName(uteacher.getFirstName());
			teacher.setLastName(uteacher.getLastName());
			teacherRepository.save(teacher);
			logger.info("Updated teacher with ID: " + teacherId.toString());
			return new ResponseEntity<TeacherEntity>(teacher, HttpStatus.OK);
		}
		return new ResponseEntity<RESTError>(new RESTError(3, "Teacher not found."), HttpStatus.NOT_FOUND);
	}

	// delete teacher
	@RequestMapping(method = RequestMethod.DELETE, value = "/{teacherId}")
	public ResponseEntity<?> deleteTeacher(@PathVariable Integer teacherId) {
		if (teacherRepository.existsById(teacherId) && teacherService.isActive(teacherId)) {
			TeacherEntity teacher = teacherRepository.findById(teacherId).get();
			teacher.setDeleted(true);
			teacherRepository.save(teacher);
			logger.info("Deleted teacher with ID: " + teacherId.toString());
			return new ResponseEntity<TeacherEntity>(teacher, HttpStatus.OK);
		}
		return new ResponseEntity<RESTError>(new RESTError(4, "Teacher not found."), HttpStatus.NOT_FOUND);
	}

	public String createErrorMessage(BindingResult result) {
		String errors = "";
		for (ObjectError error : result.getAllErrors()) {
			errors += error.getDefaultMessage();
			errors += "\n";
		}
		return errors;
	}
}