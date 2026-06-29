package com.nitisri.college_management_system.Controller;

import com.nitisri.college_management_system.Entity.College;
import com.nitisri.college_management_system.Service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colleges")
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    @PostMapping
    public College createCollege(@RequestBody College college){
        return collegeService.saveCollege(college);
    }

    @GetMapping
    public List<College> getAllColleges(){
        return collegeService.getAllColleges();
    }

    @GetMapping("/{id}")
    public College getCollegeById(@PathVariable Long id) {
        return collegeService.getCollegeById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteCollege(@PathVariable Long id){
        collegeService.deleteCollege(id);
        return "College Deleted Sucessfully";
    }

    @PutMapping("/{id}")
    public College updateCollege(@PathVariable Long id,@RequestBody College college){
        return collegeService.updateCollege(id, college);
    }

}
