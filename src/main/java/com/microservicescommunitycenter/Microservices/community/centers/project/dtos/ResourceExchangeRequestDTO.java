package com.microservicescommunitycenter.Microservices.community.centers.project.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.microservicescommunitycenter.Microservices.community.centers.project.models.enums.ResourceType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPOJOBuilder(withPrefix = "")
public class ResourceExchangeRequestDTO {

    @NotBlank
    private String originCenterId;

    @NotBlank
    private String destinationCenterId;

    @NotNull
    private Map<ResourceType, Integer> resourcesSubmittedOrigin;

    @NotNull
    private Map<ResourceType, Integer> resourcesSentDestination;
}
