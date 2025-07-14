package dtos.convert;

import dtos.CommunityCenterRequestDTO;
import dtos.CommunityCenterResponseDTO;
import models.CommunityCenter;


public class CommunityCenterMapper {

    public static CommunityCenter toEntity(CommunityCenterRequestDTO dto) {
        return CommunityCenter.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .maximumCapacity(dto.getMaximumCapacity())
                .CurrentOccupation(dto.getCurrentOccupation())
                .recurce(dto.getRecurce())
                .build();
    }

    public static CommunityCenterResponseDTO toDTO(CommunityCenter entity) {
        return CommunityCenterResponseDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .address(entity.getAddress())
                .latitude(entity.getLatitude())
                .longitude(entity.getLongitude())
                .maximumCapacity(entity.getMaximumCapacity())
                .CurrentOccupation(entity.getCurrentOccupation())
                .recurce(entity.getRecurce())
                .build();
    }
}
