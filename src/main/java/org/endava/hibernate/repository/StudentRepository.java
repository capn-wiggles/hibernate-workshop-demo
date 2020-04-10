package org.endava.hibernate.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.endava.hibernate.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Repository
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class StudentRepository implements CustomRepository<Student> {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public Student saveEntity(Student entity) {
        log.info(String.format("Saving Student(%s) to database", entity.getName()));

        entityManager.persist(entity);

        return entity;
    }

    @Override
    public List<Student> findAll() {
        log.info("Fetching all students");

        Query query = entityManager.createQuery("SELECT s FROM Student s");

        List<Student> allStudents = query.getResultList();

        return allStudents;
    }

    @Override
    public Student findById(long id) {
        log.info(String.format("Fetching a student with id=%d", id));

        Student student = entityManager.find(Student.class, id);

        return student;
    }
}
