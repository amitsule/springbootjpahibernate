package com.cognitech.springbootjpahibernate.dao;

import com.cognitech.springbootjpahibernate.entity.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class InstructorDAOImpl implements InstructorDAO
{
    private EntityManager entityManager;

    //---------------------------------------------------------------------------------------------
    @Autowired
    public InstructorDAOImpl(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    //---------------------------------------------------------------------------------------------
    @Override
    @Transactional
    public void saveInstructor(Instructor instructor)
    {
        this.entityManager.persist(instructor);
    }

    //---------------------------------------------------------------------------------------------
    @Override
    public Optional<Instructor> findInstructorById(Long id)
    {
        Optional<Instructor> result = Optional.ofNullable(this.entityManager.find(Instructor.class, id));
        return result;
    }

    //---------------------------------------------------------------------------------------------
    @Override
    @Transactional
    public void deleteInstructorById(Long id)
    {
        Optional<Instructor> result = findInstructorById(id);
        result.ifPresent(instructor -> this.entityManager.remove(instructor));
    }
}
