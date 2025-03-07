package com.cognitech.springbootjpahibernate;

import com.cognitech.springbootjpahibernate.dao.InstructorDAO;
import com.cognitech.springbootjpahibernate.entity.Course;
import com.cognitech.springbootjpahibernate.entity.Instructor;
import com.cognitech.springbootjpahibernate.entity.InstructorDetail;
import com.cognitech.springbootjpahibernate.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
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

//			findInstructor(instructorDAO, 1);

//			createAdditionalInstructors(instructorDAO);

//			deleteInstructor(instructorDAO, 9);
//			findInstructor(instructorDAO, 9);

//			findInstructorDetail(instructorDAO, 9);

//			createInstructorAndCourses(instructorDAO);
//			createCourses(instructorDAO);

//			updateCourse(instructorDAO);

//			deleteInstructor(instructorDAO, 10);

//			createCourseAndStudents(instructorDAO);
//			findCourseAndStudents(instructorDAO);
//			findStudentAndCourses(instructorDAO);
			addMoreCoursesForStudent(instructorDAO);
		};
	}

	//---------------------------------------------------------------------------------------------
	private void addMoreCoursesForStudent(InstructorDAO instructorDAO)
	{
		Course newCourse = new Course("Dungeons and Dragons");

		long id = 3;
		Optional<Student> studentResult = instructorDAO.findStudentAndCoursesById(id);
		studentResult.ifPresent(student -> {
			student.addCourse(newCourse);
			instructorDAO.updateStudent(student);
		});
	}

	//---------------------------------------------------------------------------------------------
	private void findStudentAndCourses(InstructorDAO instructorDAO)
	{
		long id = 3;
		Optional<Student> result = instructorDAO.findStudentAndCoursesById(id);
		result.ifPresent(student -> {
						System.out.println("Student : " + student);
						System.out.println("Courses : " + student.getCourses());
		});
	}

	//---------------------------------------------------------------------------------------------
	private void findCourseAndStudents(InstructorDAO instructorDAO)
	{
		long id = 15;
		Optional<Course> result = instructorDAO.findCourseAndStudentsById(id);
		result.ifPresent(course -> {
							System.out.println("Course : " + course.toString());
							System.out.println("Students : " + course.getStudents());
		});
	}

	//---------------------------------------------------------------------------------------------
	private void createCourseAndStudents(InstructorDAO instructorDAO)
	{
		Course course = new Course("Mathematics");

		Student student1 = new Student("Inika", "Sule", "inika@gmail.com");
		Student student2 = new Student("Stella", "N", "stella@gmail.com");
		Student student3 = new Student("Juliet", "J", "juliet@gmail.com");

		//--- Add students to courses
		course.addStudent(student1);
		course.addStudent(student2);
		course.addStudent(student3);

		//--- Save courses and associated students
		instructorDAO.saveCourse(course);
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
	private void findInstructor(InstructorDAO instructorDAO, long id)
	{
		Optional<Instructor> instructor = instructorDAO.findInstructorAndCoursesById(id);
		instructor.ifPresentOrElse(instr -> {
										System.out.println(instr);
										System.out.println(instr.getCourses());
									},
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

	//---------------------------------------------------------------------------------------------
	private void createCourses(InstructorDAO instructorDAO)
	{
		Course course1 = new Course("Java Programming");
		Course course2 = new Course("Golang Programming");
		Course course3 = new Course("Python Programming");
		Course course4 = new Course("Guitar");
		Course course5 = new Course("Drums");
		Course course6 = new Course("Piano");

		long id = 10;
		Optional<Instructor> instructor = instructorDAO.findInstructorAndCoursesById(id);
		instructor.ifPresent(instr -> {
							System.out.println(instr.toString());
							System.out.println(instr.getCourses());
		});

		id = 1;
		instructor = instructorDAO.findInstructorById(id);
		if (instructor.isPresent())
		{
			Instructor instr = instructor.get();
			List<Course> courses = instructorDAO.findCoursesByInstructorId(id);
			if (courses != null)
			{
				instr.setCourses(courses);
				instr.addCourse(course1);
				instr.addCourse(course4);
				instr.addCourse(course5);
			}
			instructorDAO.updateInstructor(instr);
		}

		id = 2;
		instructor = instructorDAO.findInstructorById(id);
		if (instructor.isPresent())
		{
			Instructor instr = instructor.get();
			List<Course> courses = instructorDAO.findCoursesByInstructorId(id);
			if (courses != null)
			{
				instr.setCourses(courses);
				instr.addCourse(course2);
				instr.addCourse(course3);
				instr.addCourse(course6);
			}
			instructorDAO.updateInstructor(instr);
		}
	}

	//---------------------------------------------------------------------------------------------
	private void createInstructorAndCourses(InstructorDAO instructorDAO)
	{
		Instructor instructor = new Instructor("John", "Smith", "john@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/HS86743GS", "Video Games");
		instructor.setInstructorDetail(instructorDetail);
		Course course1 = new Course("Programming 101");
		Course course2 = new Course("Wiring Routers");
		instructor.addCourse(course1);
		instructor.addCourse(course2);
		instructorDAO.saveInstructor(instructor);
	}

	//---------------------------------------------------------------------------------------------
	private void updateCourse(InstructorDAO instructorDAO)
	{
		long id = 2;
		Optional<Course> course = instructorDAO.findCourseById(id);
		course.ifPresent(cr -> {
			System.out.println(course);
			cr.setTitle("Wiring Networks & Routers");
			instructorDAO.updateCourse(cr);
		});
	}
}
