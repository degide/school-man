package com.egide.schoolman.services;

import java.util.List;

import com.egide.schoolman.models.Student;
import com.egide.schoolman.services.dtos.StudentDTO;

public interface StudentService {
	public Student save(StudentDTO dto) throws Exception;
	public List<Student> getAll() throws Exception;
	public List<Student> getByFirstNameAndLastName(String firstName, String lastName) throws Exception;
}
