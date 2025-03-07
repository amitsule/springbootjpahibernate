package com.cognitech.springbootjpahibernate.dao;

import com.cognitech.springbootjpahibernate.entity.Course;
import com.cognitech.springbootjpahibernate.entity.Instructor;
import com.cognitech.springbootjpahibernate.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Repository
@EnableAutoConfiguration
public class InstructorDAOImpl implements InstructorDAO
{
    private final EntityManager entityManager;

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
    @Transactional
    public void updateInstructor(Instructor instructor)
    {
        this.entityManager.merge(instructor);
    }

    //---------------------------------------------------------------------------------------------
    @Override
    @Transactional
    public void deleteInstructorById(long id)
    {
        Optional<Instructor> instructor = this.findInstructorById(id);
        instructor.ifPresent(instr -> {
            List<Course> courses = instr.getCourses();
            if (!CollectionUtils.isEmpty(courses))
            {
                for (Course course : courses)
                {
                    course.setInstructor(null);
                }
            }
            this.entityManager.remove(instr);
        });
    }

    //---------------------------------------------------------------------------------------------
    @Override
    public Optional<Instructor> findInstructorById(long id)
    {
        return Optional.ofNullable(this.entityManager.find(Instructor.class, id));
    }

    //---------------------------------------------------------------------------------------------
    @Override
    public Optional<InstructorDetail> findInstructorDetailById(long id)
    {
        return Optional.ofNullable(this.entityManager.find(InstructorDetail.class, id));
    }

    //---------------------------------------------------------------------------------------------
    @Override
    public List<Course> findCoursesByInstructorId(long id)
    {
        TypedQuery<Course> query = this.entityManager.createQuery("FROM Course WHERE instructor.id = :id", Course.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    //---------------------------------------------------------------------------------------------
    @Override
    public Optional<Instructor> findInstructorAndCoursesById(long id)
    {
        TypedQuery<Instructor> query = this.entityManager.createQuery("SELECT inst FROM Instructor inst "
                                                                    + "JOIN FETCH inst.instructorDetail "
                                                                    + "JOIN FETCH inst.courses "
                                                                    + "WHERE inst.id = :id", Instructor.class);
        query.setParameter("id", id);
        Instructor instructor = query.getSingleResult();
        return Optional.of(instructor);
    }

    //---------------------------------------------------------------------------------------------
    @Override
    public Optional<Course> findCourseById(long id)
    {
        Course course = this.entityManager.find(Course.class, id);
        return Optional.of(course);
    }

    //---------------------------------------------------------------------------------------------
    @Override
    @Transactional
    public void updateCourse(Course course)
    {
        this.entityManager.merge(course);
    }
}
