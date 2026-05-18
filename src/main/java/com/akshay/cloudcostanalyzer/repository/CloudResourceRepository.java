package com.akshay.cloudcostanalyzer.repository;

import com.akshay.cloudcostanalyzer.entity.CloudResource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CloudResourceRepository extends JpaRepository<CloudResource, Long> {
}