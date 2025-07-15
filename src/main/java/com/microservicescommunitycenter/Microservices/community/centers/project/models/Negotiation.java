package com.microservicescommunitycenter.Microservices.community.centers.project.models;

import lombok.*;
import com.microservicescommunitycenter.Microservices.community.centers.project.models.enums.ResourceType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.EnumMap;
import java.util.Map;
import java.util.UUID;

@Document(collection = "negotiations")
@Getter
@Setter
@Builder
public class Negotiation {

    @Id
    private String id;
    private String originCenterId;
    private String destinationCenterId;
    private LocalDateTime dateTime;
    private Boolean validatedasunfair;

    // Recursos enviados do centro de origem para o destino
    private Map<ResourceType, Integer> resourcesSubmittedOrigin = new EnumMap<>(ResourceType.class);

    // Recursos enviados do centro de destino para a origem
    private Map<ResourceType, Integer> resourcesSentDestination = new EnumMap<>(ResourceType.class);

}
