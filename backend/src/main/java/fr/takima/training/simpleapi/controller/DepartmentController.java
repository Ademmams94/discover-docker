package fr.takima.training.simpleapi.controller;

import fr.takima.training.simpleapi.model.Department;
import fr.takima.training.simpleapi.model.Student;
import fr.takima.training.simpleapi.repository.DepartmentRepository;
import fr.takima.training.simpleapi.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    private final DepartmentRepository departmentRepository;
    private final StudentRepository studentRepository;

    public DepartmentController(DepartmentRepository departmentRepository,
                                StudentRepository studentRepository) {
        this.departmentRepository = departmentRepository;
        this.studentRepository = studentRepository;
    }

    @GetMapping("/departments/{name}/students")
    public List<Student> getStudents(@PathVariable String name) {
        Department dept = departmentRepository.findByName(name);
        return studentRepository.findByDepartment(dept);
    }
}