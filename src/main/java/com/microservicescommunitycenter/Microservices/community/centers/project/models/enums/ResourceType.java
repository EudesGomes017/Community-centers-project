package com.microservicescommunitycenter.Microservices.community.centers.project.models.enums;

import lombok.Getter;

@Getter
public enum ResourceType {
    DOCTOR(4),
    VOLUNTARY(3),
    MEDICAL_KIT(7),
    VEHICLE(5),
    BASIC_BASKET(2);

    private final int points;

    ResourceType(int points) {
        this.points = points;
    }

}
