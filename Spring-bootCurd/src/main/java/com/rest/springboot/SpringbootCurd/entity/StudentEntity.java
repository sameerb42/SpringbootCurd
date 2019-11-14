package com.rest.springboot.SpringbootCurd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table(name = "STUDENTS")
public class StudentEntity {

	@Id
	
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")	
	private String name;
	
	@Column(name = "english_marks")
	@Min(value=0, message="Marks should be positive")
	private float englishMarks;
	
	@Column(name = "science_marks")
	@Min(value=0, message="Marks should be positive")
	private float scienceMarks;
	
	
	@Column(name = "maths_marks")
	@Min(value=0, message="Marks should be positive")
	private float mathsMarks;

	public StudentEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getEnglishMarks() {
		return englishMarks;
	}

	public void setEnglishMarks(float englishMarks) {
		this.englishMarks = englishMarks;
	}

	public float getScienceMarks() {
		return scienceMarks;
	}

	public void setScienceMarks(float scienceMarks) {
		this.scienceMarks = scienceMarks;
	}

	public float getMathsMarks() {
		return mathsMarks;
	}

	public void setMathsMarks(float mathsMarks) {
		this.mathsMarks = mathsMarks;
	}

	public StudentEntity(String name, float englishMarks, float scienceMarks, float mathsMarks) {
		super();
		this.name = name;
		this.englishMarks = englishMarks;
		this.scienceMarks = scienceMarks;
		this.mathsMarks = mathsMarks;
	}

	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", name=" + name + ", englishMarks=" + englishMarks + ", scienceMarks="
				+ scienceMarks + ", mathsMarks=" + mathsMarks + "]";
	}

}
