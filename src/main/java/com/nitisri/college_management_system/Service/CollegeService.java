package com.nitisri.college_management_system.Service;

import com.nitisri.college_management_system.Entity.College;
import com.nitisri.college_management_system.Exception.ResourceNotFoundException;
import com.nitisri.college_management_system.Repository.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeService {

    @Autowired
    private CollegeRepository collegeRepository;

    public College saveCollege(College college){
        return collegeRepository.save(college);
    }

    public List<College> getAllColleges(){
        return collegeRepository.findAll();
    }

    public College getCollegeById(Long id) {
        return collegeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("College not found with id: " + id));
    }
    public void deleteCollege(Long id){
        College college = collegeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("College not found with id: " + id));

        collegeRepository.delete(college);
    }
    public College updateCollege(Long id, College college) {
        College existingCollege = collegeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("College not found with id: " + id));

        existingCollege.setCollegeName(college.getCollegeName());
        existingCollege.setCollegeAddress(college.getCollegeAddress());

        return collegeRepository.save(existingCollege);
    }

}
