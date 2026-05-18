package com.akshay.cloudcostanalyzer.service;

import com.akshay.cloudcostanalyzer.entity.CloudResource;
import com.akshay.cloudcostanalyzer.repository.CloudResourceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudResourceService {

    private final CloudResourceRepository repository;

    public CloudResourceService(CloudResourceRepository repository) {
        this.repository = repository;
    }

    public CloudResource saveResource(CloudResource resource) {
        return repository.save(resource);
    }

    public List<CloudResource> getAllResources() {
        return repository.findAll();
    }
}