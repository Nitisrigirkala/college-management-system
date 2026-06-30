package com.nitisri.college_management_system.Service;

import com.nitisri.college_management_system.Entity.College;
import com.nitisri.college_management_system.Exception.ResourceNotFoundException;
import com.nitisri.college_management_system.Repository.CollegeRepository;
import com.nitisri.college_management_system.dto.request.CreateCollegeRequest;
import com.nitisri.college_management_system.dto.request.UpdateCollegeRequest;
import com.nitisri.college_management_system.dto.response.CollegeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollegeService {

    @Autowired
    private CollegeRepository collegeRepository;

    public CollegeResponse saveCollege(CreateCollegeRequest request) {

        College college = new College();

        college.setCollegeName(request.getCollegeName());
        college.setCollegeAddress(request.getCollegeAddress());

        College savedCollege = collegeRepository.save(college);

        return mapToCollegeResponse(savedCollege);
    }


    public List<CollegeResponse> getAllColleges() {

        List<College> colleges = collegeRepository.findAll();

        List<CollegeResponse> responseList = new ArrayList<>();

        for (College college : colleges) {

            responseList.add(mapToCollegeResponse(college));
        }

        return responseList;
    }


    public CollegeResponse getCollegeById(Long id) {

        College college = collegeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("College not found with id: " + id));

        return mapToCollegeResponse(college);
    }

    public void deleteCollege(Long id){
        College college = collegeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("College not found with id: " + id));

        collegeRepository.delete(college);
    }

    public CollegeResponse updateCollege(Long id, UpdateCollegeRequest request) {

        College existingCollege = collegeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("College not found with id: " + id));

        existingCollege.setCollegeName(request.getCollegeName());
        existingCollege.setCollegeAddress(request.getCollegeAddress());

        College updatedCollege = collegeRepository.save(existingCollege);

        return mapToCollegeResponse(updatedCollege);
    }

    private CollegeResponse mapToCollegeResponse(College college) {

        CollegeResponse response = new CollegeResponse();

        response.setCollegeId(college.getCollegeId());
        response.setCollegeName(college.getCollegeName());
        response.setCollegeAddress(college.getCollegeAddress());

        return response;
    }
}
