package com.nitisri.college_management_system.Service;


import com.nitisri.college_management_system.Entity.Subject;
import com.nitisri.college_management_system.Exception.ResourceNotFoundException;
import com.nitisri.college_management_system.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Subject getSubjectById(Long id) {
        return subjectRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Subject not found with id: " + id));
    }


    public void deleteSubject(Long id) {

        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Subject not found with id: " + id));

        subjectRepository.delete(subject);
    }

    public Subject updateSubject(Long id, Subject subject){

        Subject existingSubject = subjectRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Subject not found with id: " + id));

        existingSubject.setSubjectName(subject.getSubjectName());
        existingSubject.setStartDate(subject.getStartDate());
        existingSubject.setEndDate(subject.getEndDate());

        return subjectRepository.save(existingSubject);
    }

}
