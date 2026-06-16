package com.nitisri.college_management_system.Repository;

import com.nitisri.college_management_system.Entity.Student;
import com.nitisri.college_management_system.Entity.StudentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDetailsRepository extends JpaRepository<StudentDetails, Long> {
}
