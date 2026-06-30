package com.nitisri.college_management_system.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {
    private Long studentID;
    private String studentName;
    private String email;
    private String collegeName;
}
