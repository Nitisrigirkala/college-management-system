package com.nitisri.college_management_system.Controller;


import com.nitisri.college_management_system.Entity.Student;
import com.nitisri.college_management_system.Service.StudentService;
import com.nitisri.college_management_system.dto.request.CreateStudentRequest;
import com.nitisri.college_management_system.dto.request.UpdateStudentRequest;
import com.nitisri.college_management_system.dto.response.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public StudentResponse createStudent(@RequestBody CreateStudentRequest request){
        return studentService.saveStudent(request);
    }

    @GetMapping
    public List<StudentResponse> getAllStudents(){
        return studentService.getAllStudents();
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "Student Deleted Sucessfully";
    }

    @GetMapping("/{id}")
    public StudentResponse getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public StudentResponse updateStudent(@PathVariable Long id,
                                         @RequestBody UpdateStudentRequest request){
        return studentService.updateStudent(id, request);
    }



}
