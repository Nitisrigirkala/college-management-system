package com.nitisri.college_management_system.Service;


import com.nitisri.college_management_system.Entity.Student;
import com.nitisri.college_management_system.Entity.StudentDetails;
import com.nitisri.college_management_system.Exception.ResourceNotFoundException;
import com.nitisri.college_management_system.Repository.StudentDetailsRepository;
import com.nitisri.college_management_system.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentDetailsService {
    @Autowired
    private StudentDetailsRepository studentDetailsRepository;

    @Autowired
    private StudentRepository studentRepository;

    public StudentDetails saveStudentDetails(StudentDetails studentDetails){
        Long studentId = studentDetails.getStudent().getStudentID();
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student not found with id: " + studentId));
        studentDetails.setStudent(student);
        return studentDetailsRepository.save(studentDetails);

    }

    public List<StudentDetails> getAllStudentDetails(){
        return studentDetailsRepository.findAll();
    }

    public StudentDetails getStudentDetailsByID(Long id){
        return studentDetailsRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student Details not found with id: " + id));
    }

    public StudentDetails updateStudentDetails(Long id, StudentDetails studentDetails){
        StudentDetails existingDetails = studentDetailsRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student Details not found with id: " + id));

        existingDetails.setPhoneNo(studentDetails.getPhoneNo());
        existingDetails.setStudentAddress(studentDetails.getStudentAddress());
        existingDetails.setGender(studentDetails.getGender());
        existingDetails.setDob(studentDetails.getDob());
        existingDetails.setCgpa(studentDetails.getCgpa());
        existingDetails.setIsActive(studentDetails.getIsActive());

        return studentDetailsRepository.save(existingDetails);
    }

    public void deleteStudentDetails(Long id){
        StudentDetails studentDetails = studentDetailsRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student Details not found with id: " + id));

        studentDetailsRepository.delete(studentDetails);
    }

}
