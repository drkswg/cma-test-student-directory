package com.drkswg.crudapp.service;

import com.drkswg.crudapp.entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> findAll();
    public Student findById(int id);
    public void save(Student student);
    public void deleteById(int id);
}
