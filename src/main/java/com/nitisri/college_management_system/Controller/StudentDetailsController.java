package com.nitisri.college_management_system.Controller;


import com.nitisri.college_management_system.Entity.StudentDetails;
import com.nitisri.college_management_system.Service.StudentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentDetails")
public class StudentDetailsController {

    @Autowired
    private StudentDetailsService studentDetailsService;

    @PostMapping
    public StudentDetails saveStudentDetails(@RequestBody StudentDetails studentDetails){
        return studentDetailsService.saveStudentDetails(studentDetails);
    }

    @GetMapping
    public List<StudentDetails> getAllStudentDetails(){
        return studentDetailsService.getAllStudentDetails();
    }

    @GetMapping("/{id}")
    public StudentDetails getStudentDetailsById(@PathVariable Long id){
        return studentDetailsService.getStudentDetailsByID(id);
    }

    @PutMapping("/{id}")
    public StudentDetails updateStudentDetails(
            @PathVariable Long id,
            @RequestBody StudentDetails studentDetails){

        return studentDetailsService.updateStudentDetails(id, studentDetails);
    }

    @DeleteMapping("/{id}")
    public String deleteStudentDetails(@PathVariable Long id){

        studentDetailsService.deleteStudentDetails(id);
        return "Student Details Deleted Sucessfully";
    }

}
