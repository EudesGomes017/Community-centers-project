package com.microservicescommunitycenter.Microservices.community.centers.project.services;

import com.microservicescommunitycenter.Microservices.community.centers.project.dtos.ResourceExchangeRequestDTO;
import com.microservicescommunitycenter.Microservices.community.centers.project.models.CommunityCenter;
import com.microservicescommunitycenter.Microservices.community.centers.project.models.Negotiation;
import com.microservicescommunitycenter.Microservices.community.centers.project.models.enums.ResourceType;
import com.microservicescommunitycenter.Microservices.community.centers.project.repositories.CommunityCenterRepository;
import com.microservicescommunitycenter.Microservices.community.centers.project.repositories.RepositoryNegotiation;
import com.microservicescommunitycenter.Microservices.community.centers.project.services.interfaces.INegotiation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class NegotiationService implements INegotiation {

    @Autowired
    private CommunityCenterRepository communityCenterRepository;

    @Autowired
    private RepositoryNegotiation repositoryNegotiation;


    @Override
    public Negotiation carryNegotiation(ResourceExchangeRequestDTO dto) {
        CommunityCenter origin = communityCenterRepository.findById(dto.getOriginCenterId())
                .orElseThrow(() -> new IllegalArgumentException("Centro de origem não encontrado"));

        CommunityCenter destination = communityCenterRepository.findById(dto.getDestinationCenterId())
                .orElseThrow(() -> new IllegalArgumentException("Centro destino não encontrado"));

        int pointsOrigin = calculatescore(dto.getResourcesSubmittedOrigin());
        int destinationPoints = calculatescore(dto.getResourcesSentDestination());

        boolean originCritic = isCritical(origin);
        boolean criticalDestination = isCritical(destination);

        // Validação da pontuação: se nenhum dos dois está em estado crítico, os pontos precisam bater
        if (!originCritic && !criticalDestination && pointsOrigin != destinationPoints) {
            throw new IllegalArgumentException("Pontuação incompatível entre os centros.");
        }

        // Verifica se centros possuem os recursos informados
        validateAvailability(origin, dto.getResourcesSubmittedOrigin()); // origem perde
        validateAvailability(destination, dto.getResourcesSentDestination()); // destino perde

        transferResources(origin, dto.getResourcesSentDestination(), true); // origem recebe
        transferResources(destination, dto.getResourcesSubmittedOrigin(), true); // destino recebe

        communityCenterRepository.save(origin);
        communityCenterRepository.save(destination);

        // Registra negociação
        Negotiation negotiation = Negotiation.builder()
                .originCenterId(origin.getId())
                .destinationCenterId(destination.getId())
                .resourcesSubmittedOrigin(dto.getResourcesSubmittedOrigin())
                .resourcesSentDestination(dto.getResourcesSentDestination())
                .dateTime(LocalDateTime.now())
                .validatedasunfair(pointsOrigin != destinationPoints)
                .build();


        return repositoryNegotiation.save(negotiation);
    }

    private void transferResources(CommunityCenter center, Map<ResourceType, Integer> requiredResources, boolean add) {
        requiredResources.forEach((type, qtd) -> {
            center.getRecurce().merge(type, qtd, (oldVal, newVal) -> add ? oldVal + newVal : oldVal - newVal);

        });
    }

    private void validateAvailability(CommunityCenter center, Map<ResourceType, Integer> requiredResources) {

        requiredResources.forEach((type, qtd) -> {
            int available = center.getRecurce().getOrDefault(type, 0);
            if (available < qtd) {
                throw new IllegalArgumentException("Centro " + center.getName() + " não possui recurso suficiente: " + type);
            }
        });

    }

    private boolean isCritical(CommunityCenter center) {

        return (double) center.getCurrentOccupation() / center.getMaximumCapacity() > 0.9;
    }

    private int calculatescore(Map<ResourceType, Integer> recurse) {
        return recurse.entrySet().stream().mapToInt(e -> e.getKey().getPoints() * e.getValue()).sum();
    }
}
