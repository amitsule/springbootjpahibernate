package com.cognitech.springbootjpahibernate.dao;

import com.cognitech.springbootjpahibernate.entity.Course;
import com.cognitech.springbootjpahibernate.entity.Instructor;
import com.cognitech.springbootjpahibernate.entity.InstructorDetail;
import com.cognitech.springbootjpahibernate.entity.Student;

import java.util.List;
import java.util.Optional;

public interface InstructorDAO
{
    void saveInstructor(Instructor instructor);

    void updateInstructor(Instructor instructor);

    Optional<Instructor> findInstructorById(long id);

    void deleteInstructorById(long id);

    Optional<InstructorDetail> findInstructorDetailById(long id);

    List<Course> findCoursesByInstructorId(long id);

    Optional<Instructor> findInstructorAndCoursesById(long id);

    Optional<Course> findCourseById(long id);

    Optional<Course> findCourseByName(String name);

    void updateCourse(Course course);

    void saveCourse(Course course);

    Optional<Course> findCourseAndStudentsById(long id);

    Optional<Student> findStudentAndCoursesById(long id);

    void updateStudent(Student student);
}
