package models;

import lombok.*;
import models.enums.ResourceType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.EnumMap;
import java.util.Map;

@Document(collection = "centros_comunitarios")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommunityCenter {

    @Id
    private String id;

    private String name;
    private String address;
    private Double latitude;
    private Double longitude;

    private Integer maximumCapacity;
    private Integer CurrentOccupation;

    private Map<ResourceType, Integer> recurce = new EnumMap<>(ResourceType.class);
}
