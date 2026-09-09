package com.interntrack.interntrack.controller;

import com.interntrack.interntrack.dto.StatsResponse;
import com.interntrack.interntrack.entity.JobApplication;
import com.interntrack.interntrack.service.JobApplicationService;
import com.interntrack.interntrack.enums.ApplicationStatus;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController 
@RequestMapping ("/applications")
public class JobApplicationController {
    private final JobApplicationService service;
    public JobApplicationController(JobApplicationService service) {
        this.service = service;
    }

    @PostMapping
    public JobApplication createApplication(@Valid @RequestBody JobApplication application) {
        return service.saveApplication(application);
    }

    @GetMapping
    public List<JobApplication> getAllApplications() {
        return service.getAllApplications();
    }

    @GetMapping("/{id}")
    public JobApplication getApplicationById(@PathVariable Long id) {
        return service.getApplicationById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteApplication(@PathVariable Long id) {
        service.deleteApplication(id);
    }

    @PutMapping("/{id}")
    public JobApplication updateApplication(@PathVariable Long id, @Valid @RequestBody JobApplication updatedApplication) {
        return service.updateApplication(id, updatedApplication);
    }

    @GetMapping ("/status/{status}")
    public List<JobApplication> getApplicationsByStatus(@PathVariable ApplicationStatus status) {
        return service.getApplicationsByStatus(status);

    }

    @GetMapping ("/total")
    public long getTotalApplications() {
        return service.getTotalApplications();
    }

    @GetMapping ("/count/{status}")
    public long getApplicationsByStatusCount(@PathVariable ApplicationStatus status) {
        return service.getApplicationsByStatusCount(status);
    }

    @GetMapping ("/stats")
    public StatsResponse getStats() {
        return service.getApplicationStats();
    }

    @GetMapping ("/search")
    public List<JobApplication> searchByCompany(@RequestParam String company) {
        return service.searchByCompany(company);
    }
}
