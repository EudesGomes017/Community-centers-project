package com.microservicescommunitycenter.Microservices.community.centers.project.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OccupationCenterUpdateDTO {

    @NotNull
    @Min(0)
    private Integer CurrentOccupation;
}
