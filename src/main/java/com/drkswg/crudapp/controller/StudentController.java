package com.drkswg.crudapp.controller;

import com.drkswg.crudapp.entity.Student;
import com.drkswg.crudapp.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/list")
    public String listStudents(Model model) {
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);

        return "students/list-students";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);

        return "students/student-form";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.save(student);

        return "redirect:/students/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("studentId") int id,
                                    Model model) {
        Student student = studentService.findById(id);
        model.addAttribute("student", student);

        return "students/student-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("studentId") int id) {
        studentService.deleteById(id);

        return "redirect:/students/list";
    }
}
