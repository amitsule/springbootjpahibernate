package com.cognitech.springbootjpahibernate;

import com.cognitech.springbootjpahibernate.dao.InstructorDAO;
import com.cognitech.springbootjpahibernate.entity.Instructor;
import com.cognitech.springbootjpahibernate.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class SpringbootjpahibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootjpahibernateApplication.class, args);
		System.out.println("Server is ready.........");
	}

	//---------------------------------------------------------------------------------------------
	@Bean
	public CommandLineRunner commandLineRunner(InstructorDAO instructorDAO)
	{
		return runner -> {
//			createInstructor(instructorDAO);
			findInstructor(instructorDAO, 3L);
//			createAdditionalInstructors(instructorDAO);

//			deleteInstructor(instructorDAO, 9L);
//			findInstructor(instructorDAO, 9L);

			findInstructorDetail(instructorDAO, 9L);
		};
	}

	//---------------------------------------------------------------------------------------------
	private void deleteInstructor(InstructorDAO instructorDAO, long id)
	{
		instructorDAO.deleteInstructorById(id);
	}

	//---------------------------------------------------------------------------------------------
	private void createAdditionalInstructors(InstructorDAO instructorDAO)
	{
		System.out.println("Saving additional instructors");
		Instructor instructor1 = new Instructor("Test1", "Sule", "test1@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("youtube.com/KHSH7332", "Cricket");
		instructor1.setInstructorDetail(instructorDetail);
		instructorDAO.saveInstructor(instructor1);

		Instructor instructor2 = new Instructor("Test2", "Sule", "test2@gmail.com");
		instructorDetail = new InstructorDetail("youtube.com/ZXYA3434OPO", "Some Hobby");
		instructor2.setInstructorDetail(instructorDetail);
		instructorDAO.saveInstructor(instructor2);
	}

	//---------------------------------------------------------------------------------------------
	private void findInstructor(InstructorDAO instructorDAO, Long id)
	{
		Optional<Instructor> instructor = instructorDAO.findInstructorById(id);
		instructor.ifPresentOrElse(instr -> System.out.println(instr),
									() -> System.out.println("Instructor not found : " + id));
	}

	//--------------------------------------------------------------------------------------------
	private void findInstructorDetail(InstructorDAO instructorDAO, long id)
	{
		Optional<InstructorDetail> instructorDetail = instructorDAO.findInstructorDetailById(id);
		instructorDetail.ifPresentOrElse(obj -> System.out.println(obj.toString() + "\n" + obj.getInstructor().toString()),
									() -> System.out.println("Not found for id : " + id));
	}

	//---------------------------------------------------------------------------------------------
	private void createInstructor(InstructorDAO instructorDAO)
	{
		Instructor instructor1 = new Instructor("Amit", "Sule", "amit@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("youtube.com/KJSH722", "Badminton");
		instructor1.setInstructorDetail(instructorDetail);
		System.out.println("Saving instructor1 : " + instructor1.toString());
		instructorDAO.saveInstructor(instructor1);

		Instructor instructor2 = new Instructor("Mayura", "Sule", "mayura@gmail.com");
		instructorDetail = new InstructorDetail("youtube.com/J82HSH2", "Cycling");
		instructor2.setInstructorDetail(instructorDetail);
		System.out.println("Saving instructor2 : " + instructor2.toString());
		instructorDAO.saveInstructor(instructor2);

		Instructor instructor3 = new Instructor("Inika", "Sule", "inika@gmail.com");
		instructorDetail = new InstructorDetail("youtube.com/82ZSD342", "Minecraft");
		instructor3.setInstructorDetail(instructorDetail);
		System.out.println("Saving instructor3 : " + instructor3.toString());
		instructorDAO.saveInstructor(instructor3);
	}
}
