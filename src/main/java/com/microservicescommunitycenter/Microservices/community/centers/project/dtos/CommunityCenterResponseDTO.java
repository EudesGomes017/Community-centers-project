package com.microservicescommunitycenter.Microservices.community.centers.project.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.*;
import com.microservicescommunitycenter.Microservices.community.centers.project.models.enums.ResourceType;

import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPOJOBuilder(withPrefix = "")
public class CommunityCenterResponseDTO {

    private String id;
    private String name;
    private String address;
    private Double latitude;
    private Double longitude;
    private Integer maximumCapacity;
    private Integer CurrentOccupation;

    private Map<ResourceType, Integer> recurce;
}
