package com.akshay.cloudcostanalyzer.controller;

import com.akshay.cloudcostanalyzer.entity.CloudResource;
import com.akshay.cloudcostanalyzer.service.CloudResourceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resources")
public class CloudResourceController {

    private final CloudResourceService service;

    public CloudResourceController(CloudResourceService service) {
        this.service = service;
    }

    @PostMapping
    public CloudResource createResource(@RequestBody CloudResource resource) {
        return service.saveResource(resource);
    }

    @GetMapping
    public List<CloudResource> getAllResources() {
        return service.getAllResources();
    }
}