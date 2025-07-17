package com.microservicescommunitycenter.Microservices.community.centers.project.repositories;

import com.microservicescommunitycenter.Microservices.community.centers.project.models.CommunityCenter;
import com.microservicescommunitycenter.Microservices.community.centers.project.models.Negotiation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface RepositoryNegotiation extends MongoRepository<Negotiation, String> {

    List<Negotiation> findByOriginCenterIdOrDestinationCenterId(String originId, String destinationId);

    List<Negotiation> findByDateTimeBetweenAndOriginCenterIdOrDestinationCenterId(
            LocalDateTime initial,
            LocalDateTime finsh,
            String originId,
            String destinationId
    );
}
