package com.nitisri.college_management_system.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long StudentDetailsId;

    private Long phoneNo;
    private String studentAddress;
    private String gender;
    private LocalDate dob;
    private Double cgpa;
    private Boolean isActive;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;


}
