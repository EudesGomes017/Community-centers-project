package com.microservicescommunitycenter.Microservices.community.centers.project.utils;

import com.microservicescommunitycenter.Microservices.community.centers.project.dtos.CommunityCenterRequestDTO;
import com.microservicescommunitycenter.Microservices.community.centers.project.dtos.OccupationCenterUpdateDTO;
import com.microservicescommunitycenter.Microservices.community.centers.project.dtos.ResourceExchangeRequestDTO;
import com.microservicescommunitycenter.Microservices.community.centers.project.models.CommunityCenter;
import com.microservicescommunitycenter.Microservices.community.centers.project.models.Negotiation;
import com.microservicescommunitycenter.Microservices.community.centers.project.models.enums.ResourceType;

import java.time.LocalDateTime;
import java.util.EnumMap;
import java.util.Map;

public class Factory {

    public static CommunityCenter createCenter(String id, String nome, int capacidade, int ocupacao) {
        return CommunityCenter.builder()
                .id(id)
                .name(nome)
                .address("Rua Teste")
                .latitude(-23.5)
                .longitude(-46.6)
                .maximumCapacity(capacidade)
                .CurrentOccupation(ocupacao)
                .recurce(new EnumMap<>(Map.of(
                        ResourceType.DOCTOR, 2,
                        ResourceType.VOLUNTARY, 4,
                        ResourceType.VEHICLE, 1
                )))
                .build();
    }

    public static CommunityCenterRequestDTO createCenterRequest() {
        return CommunityCenterRequestDTO.builder()
                .name("Centro Alpha")
                .address("Rua Alpha")
                .latitude(-23.4)
                .longitude(-46.7)
                .maximumCapacity(200)
                .CurrentOccupation(50)
                .recurce(Map.of(
                        ResourceType.DOCTOR, 2,
                        ResourceType.BASIC_BASKET, 4
                ))
                .build();
    }

    public static OccupationCenterUpdateDTO createUpdateOccupationDTO(int novaOcupacao) {
        return OccupationCenterUpdateDTO.builder()
                .CurrentOccupation(novaOcupacao)
                .build();
    }

    public static ResourceExchangeRequestDTO createTrocaDTO(String origemId, String destinoId) {
        return ResourceExchangeRequestDTO.builder()
                .originCenterId(origemId)
                .destinationCenterId(destinoId)
                .resourcesSubmittedOrigin(Map.of(
                        ResourceType.VOLUNTARY, 2,
                        ResourceType.VEHICLE, 1
                ))
                .resourcesSentDestination(Map.of(
                        ResourceType.DOCTOR, 1,
                        ResourceType.MEDICAL_KIT, 1
                ))
                .build();
    }

    public static Negotiation createNegociacao(String origemId, String destinoId) {
        return Negotiation.builder()
                .id("neg-123")
                .originCenterId(origemId)
                .destinationCenterId(destinoId)
                .resourcesSubmittedOrigin(Map.of(
                        ResourceType.VOLUNTARY, 2
                ))
                .resourcesSentDestination(Map.of(
                        ResourceType.DOCTOR, 1
                ))
                .dateTime(LocalDateTime.now())
                .validatedasunfair(false)
                .build();
    }
}
