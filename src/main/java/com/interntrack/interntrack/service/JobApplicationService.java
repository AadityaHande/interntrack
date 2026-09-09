package com.interntrack.interntrack.service;

import com.interntrack.interntrack.entity.JobApplication;
import com.interntrack.interntrack.enums.ApplicationStatus;
import com.interntrack.interntrack.repository.JobApplicationRepository;
import org.springframework.stereotype.Service;
import com.interntrack.interntrack.dto.StatsResponse;

import java.util.List;

@Service 
public class JobApplicationService{
    private final JobApplicationRepository repository;

    public JobApplicationService(JobApplicationRepository repository) {
        this.repository = repository;
    }

    public JobApplication saveApplication(JobApplication application) {
        return repository.save(application);
    }

    public List<JobApplication> getAllApplications() {
        return repository.findAll();
    }   

    public List<JobApplication> searchByCompany(String company) {
        return repository.findByCompanyContainingIgnoreCase(company);
    }
    public JobApplication getApplicationById(Long id) {
        // add validation for non existent id
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Application with id " + id + " not found"));
    }

    public void deleteApplication(Long id) {
        repository.deleteById(id);
    }

    public JobApplication updateApplication(Long id, JobApplication updatedApplication) {
        return repository
                .findById(id)
                .map(existingApplication -> {
                        existingApplication.setCompany(updatedApplication.getCompany());
                        existingApplication.setRole(updatedApplication.getRole());
                        existingApplication.setStatus(updatedApplication.getStatus());
                        existingApplication.setAppliedDate(updatedApplication.getAppliedDate());
                        existingApplication.setNotes(updatedApplication.getNotes());
                        return repository.save(existingApplication);
                    }).orElse(null);
    }

    public List<JobApplication> getApplicationsByStatus(ApplicationStatus status) {
        return repository.findByStatus(status);
    }
    
    // total number of applications
    public long getTotalApplications() {
        return repository.count();
    }

    public long getApplicationsByStatusCount(ApplicationStatus status) {
        return repository.findByStatus(status).size();
    }

    public StatsResponse getApplicationStats() {
        long total = getTotalApplications();
        long applied = getApplicationsByStatusCount(ApplicationStatus.APPLIED);
        long onlineAssessment = getApplicationsByStatusCount(ApplicationStatus.ONLINE_ASSESSMENT);
        long interview = getApplicationsByStatusCount(ApplicationStatus.INTERVIEW);
        long offer = getApplicationsByStatusCount(ApplicationStatus.OFFER);
        long rejected = getApplicationsByStatusCount(ApplicationStatus.REJECTED);

        return new StatsResponse(total, applied, onlineAssessment, interview, offer, rejected);
    }
}