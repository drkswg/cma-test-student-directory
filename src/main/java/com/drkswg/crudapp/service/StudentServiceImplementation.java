package com.drkswg.crudapp.service;

import com.drkswg.crudapp.dao.StudentDAO;
import com.drkswg.crudapp.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImplementation implements StudentService {
    private StudentDAO studentDAO;

    @Autowired
    public StudentServiceImplementation(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    @Transactional
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    @Transactional
    public Student findById(int id) {
        return studentDAO.findById(id);
    }

    @Override
    @Transactional
    public void save(Student student) {
        studentDAO.save(student);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        studentDAO.deleteById(id);
    }
}
