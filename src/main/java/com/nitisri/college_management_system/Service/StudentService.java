package com.nitisri.college_management_system.Service;

import com.nitisri.college_management_system.Entity.College;
import com.nitisri.college_management_system.Entity.Student;
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

        College college = collegeRepository.findById(collegeId).get();

        student.setCollege(college);
        return studentRepository.save(student);

    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }

    public Student getStudentById(Long id){
        return studentRepository.findById(id).get();
    }

    public Student updateStudent(Long id, Student student){
        Student existingStudent = studentRepository.findById(id).get();
        existingStudent.setStudentName(student.getStudentName());
        existingStudent.setEmail(student.getEmail());

        return studentRepository.save(existingStudent);
    }
}
