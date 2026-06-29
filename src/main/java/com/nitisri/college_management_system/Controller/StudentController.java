package com.nitisri.college_management_system.Controller;


import com.nitisri.college_management_system.DTO.StudentDTO;
import com.nitisri.college_management_system.Entity.Student;
import com.nitisri.college_management_system.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "Student Deleted Sucessfully";
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @GetMapping("/dto/{id}")
    public StudentDTO getStudentDTO(@PathVariable Long id) {
        return studentService.getStudentDTOById(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id,@RequestBody Student student){
        return studentService.updateStudent(id,student);
    }



}
