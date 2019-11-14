package com.rest.springboot.SpringbootCurd.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.springboot.SpringbootCurd.entity.StudentEntity;
import com.rest.springboot.SpringbootCurd.entity.StudentEntityWithResult;
import com.rest.springboot.SpringbootCurd.entity.StudentEntityWithTotal;
import com.rest.springboot.SpringbootCurd.exception.NegativeMarksException;
import com.rest.springboot.SpringbootCurd.exception.RecordNotFoundException;
import com.rest.springboot.SpringbootCurd.repository.StudentRepoInterface;
//import com.rest.springboot.SpringbootCurd.repository.StudentRepository;
@Service
public class StudentService {
	
	@Autowired
	StudentRepoInterface repository;
     
    public List<StudentEntity> getAllStudents()
    {
        List<StudentEntity> studentList = repository.findAll();
         
        if(studentList.size() > 0) {
            return studentList;
        } else {
            return new ArrayList<StudentEntity>();
        }
    }
    
    public List<StudentEntityWithTotal> getTopStudents()
    {
        List<StudentEntity> studentList = repository.findAll();
        
        Iterator<StudentEntity> iterator = studentList.iterator();
        
        List<StudentEntityWithTotal> topList = new ArrayList<StudentEntityWithTotal>();
        
        while(iterator.hasNext()) {
			StudentEntity student = (StudentEntity) iterator.next();
			
			StudentEntityWithTotal topEntity = new StudentEntityWithTotal();
			
			topEntity.setId(student.getId());
			topEntity.setName(student.getName());
			topEntity.setEnglishMarks(student.getEnglishMarks());
			topEntity.setScienceMarks(student.getScienceMarks());
			topEntity.setMathsMarks(student.getMathsMarks());
			topEntity.setTotalMarks(student.getEnglishMarks() + student.getScienceMarks() + student.getMathsMarks());
			
			topList.add(topEntity);			
		}
        
        Collections.sort(topList);
         
        if(topList.size() > 0) {
            return topList;
        } else {
            return new ArrayList<StudentEntityWithTotal>();
        }
    }

	
    public StudentEntity createOrUpdateEmployee(StudentEntity entity) throws NegativeMarksException 
    {
        Optional<StudentEntity> student = repository.findById(entity.getId());
         
        try {
			if(student.isPresent()) 
			{
				StudentEntity newEntity = student.get();
			    newEntity.setId(entity.getId());
			    newEntity.setName(entity.getName());
			    newEntity.setEnglishMarks(entity.getEnglishMarks());
			    newEntity.setScienceMarks(entity.getScienceMarks());
			    newEntity.setMathsMarks(entity.getMathsMarks());
			    
 
			    newEntity = repository.save(newEntity);
			     
			    return newEntity;
			} else {
			    entity = repository.save(entity);
			     
			    return entity;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new NegativeMarksException("Marks cannot be negative");
			 
		}

    }

    public StudentEntity getStudentById(Long id) throws RecordNotFoundException 
    {
        Optional<StudentEntity> student = repository.findById(id);
         
        if(student.isPresent()) {
            return student.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }

	public StudentEntityWithResult getStudentByName(String name) {
		
		StudentEntity student = repository.findByName(name);
        
        if(student != null) {
        	StudentEntityWithResult topEntity = new StudentEntityWithResult();
			
			topEntity.setId(student.getId());
			topEntity.setName(student.getName());
			topEntity.setEnglishMarks(student.getEnglishMarks());
			topEntity.setScienceMarks(student.getScienceMarks());
			topEntity.setMathsMarks(student.getMathsMarks());
			topEntity.setTotalMarks(student.getEnglishMarks() + student.getScienceMarks() + student.getMathsMarks());
			if(student.getEnglishMarks() >= 30 && student.getScienceMarks() >= 30 && student.getMathsMarks() >= 30) {
				topEntity.setResult("Pass");
			}else {
				topEntity.setResult("Fail");
			}
			
			return topEntity;
        } else {
            throw new RecordNotFoundException("No employee record exist for given name");
        }
	}

	 
     
}
