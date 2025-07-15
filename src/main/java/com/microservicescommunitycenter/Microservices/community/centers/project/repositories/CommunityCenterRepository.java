package com.microservicescommunitycenter.Microservices.community.centers.project.repositories;

import com.microservicescommunitycenter.Microservices.community.centers.project.models.CommunityCenter;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface CommunityCenterRepository extends MongoRepository<CommunityCenter, String> {
}
