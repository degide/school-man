package com.egide.schoolman.services_implementation;

import java.util.List;

import javax.naming.directory.InvalidAttributesException;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.egide.schoolman.models.Student;
import com.egide.schoolman.repository.StudentRepository;
import com.egide.schoolman.services.StudentService;
import com.egide.schoolman.services.dtos.StudentDTO;

@Service
public class StudentServiceImpl implements StudentService {
//	@Autowired
	private final StudentRepository studentRepository;
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	@Transactional
	@Override
	public Student save(StudentDTO dto) throws Exception {
		return studentRepository.save(new Student(dto));
	}
	
	@Override
	public List<Student> getAll() throws Exception  {
		return studentRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
	}
	
	@Override
	public List<Student> getByFirstNameAndLastName(String firstName, String lastName) throws Exception {
		if (firstName == null || lastName==null)
			throw new InvalidAttributesException("First Name and last Name should not be empty!");
		return studentRepository.findByFirstNameAndLastNameHql(firstName, lastName);
	}
}
