package com.akshay.cloudcostanalyzer.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cloud_resources")
public class CloudResource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String resourceName;

    private String cloudProvider;

    private Double monthlyCost;

    private String region;

    public CloudResource() {
    }

    public CloudResource(Long id, String resourceName, String cloudProvider, Double monthlyCost, String region) {
        this.id = id;
        this.resourceName = resourceName;
        this.cloudProvider = cloudProvider;
        this.monthlyCost = monthlyCost;
        this.region = region;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getCloudProvider() {
        return cloudProvider;
    }

    public void setCloudProvider(String cloudProvider) {
        this.cloudProvider = cloudProvider;
    }

    public Double getMonthlyCost() {
        return monthlyCost;
    }

    public void setMonthlyCost(Double monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}