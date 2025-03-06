package com.cognitech.springbootjpahibernate.dao;

import com.cognitech.springbootjpahibernate.entity.Instructor;

import java.util.Optional;

public interface InstructorDAO
{
    void saveInstructor(Instructor instructor);

    Optional<Instructor> findInstructorById(Long id);

    void deleteInstructorById(Long id);
}
