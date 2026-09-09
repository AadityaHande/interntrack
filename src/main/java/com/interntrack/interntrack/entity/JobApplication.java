package com.interntrack.interntrack.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import com.interntrack.interntrack.enums.ApplicationStatus;

import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
// add validation annotations

@Entity 
public class JobApplication {
    @Id
    @GeneratedValue
    Long id;

    @NotBlank 
    String company;

    @NotBlank
    String role;
    // String status;
    @Enumerated(EnumType.STRING)
    @NotNull 
    ApplicationStatus status;
    
    @NotNull
    LocalDate appliedDate;
    String notes;

    public JobApplication() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    public LocalDate getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(LocalDate appliedDate) {
        this.appliedDate = appliedDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    
}