package com.nitisri.college_management_system.Service;

import com.nitisri.college_management_system.Entity.College;
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

    public void deleteCollege(Long id){
        collegeRepository.deleteById(id);
    }
    public College updateCollege(Long id, College college) {
        College existingCollege = collegeRepository.findById(id).get();

        existingCollege.setCollegeName(college.getCollegeName());
        existingCollege.setCollegeAddress(college.getCollegeAddress());

        return collegeRepository.save(existingCollege);
    }

}
