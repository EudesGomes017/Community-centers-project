package dtos;

import jakarta.validation.constraints.*;
import lombok.*;
import models.enums.ResourceType;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommunityCenterRequestDTO {



    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @DecimalMin(value = "-90.0") @DecimalMax(value = "90.0")
    private double latitude;

    @DecimalMin(value = "-180.0") @DecimalMax(value = "180.0")
    private double longitude;

    @Min(1)
    private int maximumCapacity;

    @Min(0)
    private int CurrentOccupation;

    @NotNull
    private Map<ResourceType, Integer> recurce;
}
