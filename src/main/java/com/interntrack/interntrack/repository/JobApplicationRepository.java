package com.interntrack.interntrack.repository;
import com.interntrack.interntrack.entity.JobApplication;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.interntrack.interntrack.enums.ApplicationStatus;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
    List<JobApplication> findByStatus(ApplicationStatus status);
    List<JobApplication> findByCompanyContainingIgnoreCase(String company);
}