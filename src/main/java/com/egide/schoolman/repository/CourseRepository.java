package com.egide.schoolman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.egide.schoolman.models.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{}
