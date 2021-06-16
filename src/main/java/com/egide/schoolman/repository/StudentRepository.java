package com.egide.schoolman.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.egide.schoolman.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	//Query by custom dynamic finders
	List<Student> findByFirstName(String firstName);
	List<Student> findByFirstNameAndLastName(String firstName, String lastName);
	List<Student> findByFirstNameOrLastName(String firstName, String lastName);
	
	//Query by Hql
    @Query(value = "select id,firstName,lastName,gender from Student where firstName=:firstName or lastName=:lastName")
    List<Student> findByFirstNameAndLastNameHql(@Param("firstName") String firstName,@Param("lastName") String lastName);
    //Query by Sql
    @Query(value = "select * from student stb where stb.first_name=:firstName and stb.last_name=:lastName",nativeQuery = true)
    List<Student> findByFirstNameOrLastNameHql(@Param("firstName") String firstName,@Param("lastName") String lastName);
}
