package com.nitisri.college_management_system.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCollegeRequest {

    private String collegeName;
    private String collegeAddress;

}