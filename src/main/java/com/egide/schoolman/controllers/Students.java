package com.egide.schoolman.controllers;

import java.net.URISyntaxException;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.egide.schoolman.models.Student;
import com.egide.schoolman.services.dtos.SchoolManResponseDto;
import com.egide.schoolman.services.dtos.StudentDTO;
import com.egide.schoolman.services.StudentService;
@RestController
@RequestMapping("/schl_man/v1/students")
public class Students {
	private final Logger log = LoggerFactory.getLogger(Students.class);
	private final StudentService studentService;
	public Students(StudentService studentService) {
		this.studentService = studentService;
	}
	@PostMapping("/addStudent")
	public ResponseEntity<SchoolManResponseDto> createStudent(@Valid @RequestBody StudentDTO studentDto)
			throws URISyntaxException {
		log.info("REST request to save studentDto : {}", studentDto);
		Student std = null;
		try {
			
			std = studentService.save(studentDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest()
					.body(new SchoolManResponseDto(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null));
		}
		return ResponseEntity.ok()
				.body(new SchoolManResponseDto(HttpStatus.OK, "SUCCESSIFULLY RECORDED", new StudentDTO(std)));
	}
}
