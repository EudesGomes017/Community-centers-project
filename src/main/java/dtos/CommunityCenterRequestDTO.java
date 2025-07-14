package dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import jakarta.validation.constraints.*;
import lombok.*;
import models.enums.ResourceType;

import java.util.Map;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPOJOBuilder(withPrefix = "")
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
