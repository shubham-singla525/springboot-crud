package com.datasource.crudhibernate;

import com.datasource.crudhibernate.dao.StudentDao;
import com.datasource.crudhibernate.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudhibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudhibernateApplication.class, args);
	}

//	#This is a way to run spring standalone application
	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao){

		return runner -> {
			//createStudent(studentDao);

//			retrieveStudent(studentDao);

//			createMultipleStudents(studentDao);

			retrieveAllStudents(studentDao);
		};
	}

	private void retrieveAllStudents(StudentDao studentDao) {
		System.out.println("Retrieving all students .../");

		List<Student> students = studentDao.findAll();

		for(Student student: students){
			System.out.println("Students: "+ student);
		}
	}

	private void createMultipleStudents(StudentDao studentDao) {
		System.out.println("Creating multiple students ....");

		Student tempStudent1 = new Student("Manish","Singla","manishsingla177@gmail.com");
		Student tempStudent2 = new Student("Ayush","Singla","ayushsingla12@gmail.com");
		Student tempStudent3 = new Student("Prateek","Gupta","guptap45@gmail.com");

		System.out.println("Saving students .../");
		studentDao.save(tempStudent1);
		studentDao.save(tempStudent2);
		studentDao.save(tempStudent3);

		System.out.println("Students saved");
	}

	private void retrieveStudent(StudentDao studentDao) {
		//create student object
		System.out.println("Creating student object..../");
		Student tempStudent = new Student("Shubh","Singla","singlashubham49@gmail.com");

		//save student object
		System.out.println("Saving student object .../");
		studentDao.save(tempStudent);

		//display the id of student saved
		System.out.println("Displaying id of saved student .../ "+ tempStudent.getId());

		//retrieve student
		System.out.println("Retrieve student ..../"+ tempStudent.getId());

		//Display found student
		System.out.println("Student is... "+ studentDao.findById(tempStudent.getId()));
	}

	private void createStudent(StudentDao studentDao) {
		//create student object
		System.out.println("Creating student object..../");
		Student tempStudent = new Student("Shubh","Singla","singlashubham49@gmail.com");

		//save student object
		System.out.println("Saving student object .../");
		studentDao.save(tempStudent);

		//display the id of student saved
		System.out.println("Displaying id of saved student .../ "+ tempStudent.getId());
	}
}