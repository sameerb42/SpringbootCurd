package com.rest.springboot.SpringbootCurd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.springboot.SpringbootCurd.entity.StudentEntity;
import com.rest.springboot.SpringbootCurd.entity.StudentEntityWithResult;
import com.rest.springboot.SpringbootCurd.entity.StudentEntityWithTotal;
import com.rest.springboot.SpringbootCurd.exception.NegativeMarksException;
import com.rest.springboot.SpringbootCurd.exception.RecordNotFoundException;
import com.rest.springboot.SpringbootCurd.service.StudentService;

 
@RestController
public class StudentController {
	
  @Autowired
  StudentService service;
	
	@GetMapping("/students")
    public ResponseEntity<List<StudentEntity>> getAllStudents() {
		
        List<StudentEntity> list = service.getAllStudents(); 
        return new ResponseEntity<List<StudentEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }
	
	@GetMapping("/students/top")
    public ResponseEntity<List<StudentEntityWithTotal>> getTopStudents() {
		
        List<StudentEntityWithTotal> list = service.getTopStudents(); 
        return new ResponseEntity<List<StudentEntityWithTotal>>(list, new HttpHeaders(), HttpStatus.OK);
    }

	@PostMapping("/student")
    public ResponseEntity<StudentEntity> createOrUpdateStudent(@RequestBody StudentEntity student)
                                                    throws  NegativeMarksException {
		try {
			StudentEntity updated = service.createOrUpdateEmployee(student);
			return new ResponseEntity<StudentEntity>(updated, new HttpHeaders(), HttpStatus.OK);
		} catch (Exception e) {
			throw new NegativeMarksException("Marks can not be negative");
		}
    }
	
	@GetMapping("/student/{id}")
    public ResponseEntity<StudentEntity> getStudentById(@PathVariable("id") Long id) 
                                                    throws RecordNotFoundException {
		StudentEntity entity = service.getStudentById(id);
 
        return new ResponseEntity<StudentEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }
	
	@GetMapping("/student/name/{name}")
    public ResponseEntity<StudentEntityWithResult> getStudentByName(@PathVariable("name") String name) 
                                                    throws RecordNotFoundException {
		StudentEntityWithResult entity = service.getStudentByName(name);
 
        return new ResponseEntity<StudentEntityWithResult>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
}
