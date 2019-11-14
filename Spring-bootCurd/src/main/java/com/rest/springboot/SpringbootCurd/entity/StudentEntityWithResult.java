package com.rest.springboot.SpringbootCurd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENTS_TOTAL")
public class StudentEntityWithResult implements Comparable<StudentEntityWithResult>{

	@Id
	@Column(name = "id")
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "english_marks")
	private float englishMarks;
	@Column(name = "science_marks")
	private float scienceMarks;
	@Column(name = "maths_marks")
	private float mathsMarks;
	@Column(name = "total_marks")
	private float totalMarks;
	private String result;

	public StudentEntityWithResult() {
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

	


	public float getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(float totalMarks) {
		this.totalMarks = totalMarks;
	}


	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}


	public StudentEntityWithResult(Long id, String name, float englishMarks, float scienceMarks, float mathsMarks,
			float totalMarks, String result) {
		super();
		this.id = id;
		this.name = name;
		this.englishMarks = englishMarks;
		this.scienceMarks = scienceMarks;
		this.mathsMarks = mathsMarks;
		this.totalMarks = totalMarks;
		this.result = result;
	}

	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", name=" + name + ", englishMarks=" + englishMarks + ", scienceMarks="
				+ scienceMarks + ", mathsMarks=" + mathsMarks + "]";
	}

	@Override
	public int compareTo(StudentEntityWithResult st) {
		if(totalMarks == st.totalMarks)  
			return 0;  
		else if(totalMarks > st.totalMarks)  
			return -1;  
		else  
			return 1;  
	}

}
