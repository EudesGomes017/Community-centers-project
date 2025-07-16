package com.microservicescommunitycenter.Microservices.community.centers.project.repositories;

import com.microservicescommunitycenter.Microservices.community.centers.project.models.CommunityCenter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CommunityCenterRepository extends MongoRepository<CommunityCenter, String> {

    @Query("{ $expr: { $gt: [ { $divide: [ \"CurrentOccupation\", \"maximumCapacity\" ] }, 0.9 ] } }")
    List<CommunityCenter> findWithOccupatioGreaterThan90();

}
