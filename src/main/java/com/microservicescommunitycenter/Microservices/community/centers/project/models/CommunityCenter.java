package com.microservicescommunitycenter.Microservices.community.centers.project.models;

import lombok.*;
import com.microservicescommunitycenter.Microservices.community.centers.project.models.enums.ResourceType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.EnumMap;
import java.util.Map;


@Document(collection = "community_center")
@Getter
@Setter
@Builder
public class CommunityCenter {

    @Id
    private String id;

    private String name;
    private String address;
    private Double latitude;
    private Double longitude;
    private Integer maximumCapacity;
    private Integer CurrentOccupation; //Ocupação atual

    private Map<ResourceType, Integer> recurce = new EnumMap<>(ResourceType.class);

}
