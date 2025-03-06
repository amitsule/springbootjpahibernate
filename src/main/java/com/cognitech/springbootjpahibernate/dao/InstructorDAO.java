package com.cognitech.springbootjpahibernate.dao;

import com.cognitech.springbootjpahibernate.entity.Instructor;
import com.cognitech.springbootjpahibernate.entity.InstructorDetail;

import java.util.Optional;

public interface InstructorDAO
{
    void saveInstructor(Instructor instructor);

    Optional<Instructor> findInstructorById(long id);

    void deleteInstructorById(long id);

    Optional<InstructorDetail> findInstructorDetailById(long id);
}
