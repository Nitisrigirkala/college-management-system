package com.nitisri.college_management_system.Controller;

import com.nitisri.college_management_system.Entity.College;
import com.nitisri.college_management_system.Service.CollegeService;
import com.nitisri.college_management_system.dto.request.UpdateCollegeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.nitisri.college_management_system.dto.request.CreateCollegeRequest;
import com.nitisri.college_management_system.dto.response.CollegeResponse;

import java.util.List;

@RestController
@RequestMapping("/colleges")
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    @PostMapping
    public CollegeResponse createCollege(@RequestBody CreateCollegeRequest request){
        return collegeService.saveCollege(request);
    }

    @GetMapping
    public List<CollegeResponse> getAllColleges(){
        return collegeService.getAllColleges();
    }

    @GetMapping("/{id}")
    public CollegeResponse getCollegeById(@PathVariable Long id) {
        return collegeService.getCollegeById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteCollege(@PathVariable Long id){
        collegeService.deleteCollege(id);
        return "College Deleted Sucessfully";
    }

    @PutMapping("/{id}")
    public CollegeResponse updateCollege(@PathVariable Long id,
                                         @RequestBody UpdateCollegeRequest request){
        return collegeService.updateCollege(id, request);
    }

}
