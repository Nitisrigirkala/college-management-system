package com.nitisri.college_management_system.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    private Long studentID;

    private String studentName;

    private String email;

    private String collegeName;

}
