package com.nitisri.college_management_system.Controller;


import com.nitisri.college_management_system.Entity.Subject;
import com.nitisri.college_management_system.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;


    @PostMapping
    public Subject saveSubject(@RequestBody Subject subject){
        return subjectService.saveSubject(subject);
    }

    @GetMapping
    public List<Subject> getAllSubjects(){
        return subjectService.getAllSubjects();
    }

    @GetMapping("/{id}")
    public Subject getSubjectId(@PathVariable Long id){
        return subjectService.getSubjectById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteSubject(@PathVariable Long id){
        subjectService.deleteSubject(id);
        return "Subject Deleted Sucessfully";
    }
}
