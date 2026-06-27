package com.nitisri.college_management_system.Service;


import com.nitisri.college_management_system.Entity.Subject;
import com.nitisri.college_management_system.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public Subject saveSubject(Subject subject){
        return subjectRepository.save(subject);
    }

    public List<Subject> getAllSubjects(){
        return subjectRepository.findAll();
    }

    public Subject getSubjectById(Long id){
        return subjectRepository.findById(id).orElse(null);
    }

    public void deleteSubject(Long id){
        subjectRepository.deleteById(id);
    }

}
