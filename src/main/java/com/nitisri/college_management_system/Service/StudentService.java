package com.nitisri.college_management_system.Service;

import com.nitisri.college_management_system.DTO.StudentDTO;
import com.nitisri.college_management_system.Entity.College;
import com.nitisri.college_management_system.Entity.Student;
import com.nitisri.college_management_system.Exception.ResourceNotFoundException;
import com.nitisri.college_management_system.Repository.CollegeRepository;
import com.nitisri.college_management_system.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    public StudentRepository studentRepository;

    @Autowired
    public CollegeRepository collegeRepository;

    public Student saveStudent(Student student) {
        Long collegeId = student.getCollege().getCollegeId();

        College college = collegeRepository.findById(collegeId)
                .orElseThrow(() -> new ResourceNotFoundException("College not found with id: " + collegeId));

        student.setCollege(college);
        return studentRepository.save(student);

    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void deleteStudent(Long id){

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));

        studentRepository.delete(student);
    }

    public Student getStudentById(Long id){
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
    }

    public StudentDTO getStudentDTOById(Long id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Student not found with id: " + id));

        StudentDTO dto = new StudentDTO();

        dto.setStudentID(student.getStudentID());
        dto.setStudentName(student.getStudentName());
        dto.setEmail(student.getEmail());
        dto.setCollegeName(student.getCollege().getCollegeName());

        return dto;
    }



    public Student updateStudent(Long id, Student student){
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
        existingStudent.setStudentName(student.getStudentName());
        existingStudent.setEmail(student.getEmail());

        return studentRepository.save(existingStudent);
    }
}
