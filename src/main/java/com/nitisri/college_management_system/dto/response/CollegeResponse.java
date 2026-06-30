package com.nitisri.college_management_system.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CollegeResponse {

    private Long collegeId;
    private String collegeName;
    private String collegeAddress;

}