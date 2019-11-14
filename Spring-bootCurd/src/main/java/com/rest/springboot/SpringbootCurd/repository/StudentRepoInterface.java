package com.rest.springboot.SpringbootCurd.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.springboot.SpringbootCurd.entity.StudentEntity;

 
@Repository
public interface StudentRepoInterface extends JpaRepository<StudentEntity, Integer> {

	Optional<StudentEntity> findById(Long id);

	StudentEntity findByName(String name);

	 
	

}
