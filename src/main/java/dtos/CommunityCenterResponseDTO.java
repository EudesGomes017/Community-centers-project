package dtos;

import lombok.*;
import models.enums.ResourceType;

import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommunityCenterResponseDTO {

    private UUID id;
    private String name;
    private String address;
    private Double latitude;
    private Double longitude;
    private Integer maximumCapacity;
    private Integer CurrentOccupation;

    private Map<ResourceType, Integer> recurce;
}
