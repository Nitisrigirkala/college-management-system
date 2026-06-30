package com.nitisri.college_management_system.Service;

import com.nitisri.college_management_system.Entity.College;
import com.nitisri.college_management_system.Entity.Student;
import com.nitisri.college_management_system.Exception.ResourceNotFoundException;
import com.nitisri.college_management_system.Repository.CollegeRepository;
import com.nitisri.college_management_system.Repository.StudentRepository;
import com.nitisri.college_management_system.dto.request.CreateStudentRequest;
import com.nitisri.college_management_system.dto.request.UpdateStudentRequest;
import com.nitisri.college_management_system.dto.response.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    public StudentRepository studentRepository;

    @Autowired
    public CollegeRepository collegeRepository;

    public StudentResponse saveStudent(CreateStudentRequest request) {
        Long collegeId = request.getCollegeId();

        College college = collegeRepository.findById(collegeId)
                .orElseThrow(() -> new ResourceNotFoundException("College not found with id: " + collegeId));

        Student student = new Student();

        student.setStudentName(request.getStudentName());
        student.setEmail(request.getEmail());
        student.setCollege(college);

        Student savedStudent = studentRepository.save(student);

        return mapToStudentResponse(savedStudent);

    }

    public List<StudentResponse> getAllStudents() {

        List<Student> students = studentRepository.findAll();

        List<StudentResponse> responseList = new ArrayList<>();

        for (Student student : students) {
            responseList.add(mapToStudentResponse(student));
        }

        return responseList;

    }

    public void deleteStudent(Long id){

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));

        studentRepository.delete(student);
    }

    public StudentResponse getStudentById(Long id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student not found with id: " + id));

        return mapToStudentResponse(student);
    }



    public StudentResponse updateStudent(Long id, UpdateStudentRequest request) {

        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student not found with id: " + id));

        existingStudent.setStudentName(request.getStudentName());
        existingStudent.setEmail(request.getEmail());

        Student updatedStudent = studentRepository.save(existingStudent);

        return mapToStudentResponse(updatedStudent);
    }

    // Helper method to convert Student Entity to StudentResponse DTO
    private StudentResponse mapToStudentResponse(Student student) {

        StudentResponse response = new StudentResponse();

        response.setStudentID(student.getStudentID());
        response.setStudentName(student.getStudentName());
        response.setEmail(student.getEmail());
        response.setCollegeName(student.getCollege().getCollegeName());

        return response;
    }

}
