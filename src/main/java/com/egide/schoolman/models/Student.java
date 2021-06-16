package com.egide.schoolman.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.egide.schoolman.services.dtos.StudentDTO;

@Entity
@Table
public class Student {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
		
		@Column(name = "first_name")
        private String firstName;
		
		@Column(name = "last_name")
        private String lastName;
		
		@Column(name = "gender")
        private String gender;
		
		@ManyToMany(fetch =  FetchType.EAGER, cascade = CascadeType.PERSIST)
        @JoinTable(
                name = "students_beds_tbl",
                joinColumns = {@JoinColumn(name = "student_id")},
                inverseJoinColumns = {@JoinColumn(name = "bed_id")}
        )
        private Set<Bed> beds = new HashSet<Bed>();

        @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
        private Set<CourseAssignment> courses = new HashSet<>();

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public Student() {}

        public Student(String firstName, String lastName , String gender) {
            this.firstName = firstName;
            this.gender = gender;
            this.lastName = lastName;
        }
        public Student(Long id){
            this.id = id;
        }
        public Student(Long id, String firstName, String lastName , String gender) {
            this.id = id;
            this.firstName = firstName;
            this.gender = gender;
            this.lastName = lastName;
        }

		public Student(StudentDTO dto) {
			this.firstName = dto.getFirstName();
            this.gender = dto.getGender();
            this.lastName = dto.getLastName();
		}

		public Set<Bed> getBeds() {
			return beds;
		}
		public void setBeds(Set<Bed> beds) {
			this.beds = beds;
		}
		
		public void setCourses(Set<CourseAssignment> courses) {
			this.courses = courses;
		}
		
		public Set<CourseAssignment> getCourses() {
			return courses;
		}
		
		@Override
		public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
		}
}

