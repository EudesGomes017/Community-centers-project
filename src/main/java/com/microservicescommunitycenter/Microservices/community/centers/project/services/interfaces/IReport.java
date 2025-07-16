package com.microservicescommunitycenter.Microservices.community.centers.project.services.interfaces;

import com.microservicescommunitycenter.Microservices.community.centers.project.models.enums.ResourceType;

import java.util.Map;

public interface IReport {

    Map<ResourceType, Double> calculateAvarageResources();
}
