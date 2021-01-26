package com.drkswg.crudapp.dao;

import com.drkswg.crudapp.entity.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class StudentDAOImplementation implements StudentDAO {
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Student> query = currentSession.createQuery("from Student", Student.class);
        List<Student> students = query.getResultList();

        return students;
    }

    @Override
    public Student findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Student student = currentSession.get(Student.class, id);

        return student;
    }

    @Override
    public void save(Student student) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(student);
    }

    @Override
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("delete from Student where id=:studentId");
        query.setParameter("studentId", id);
        query.executeUpdate();
    }
}
