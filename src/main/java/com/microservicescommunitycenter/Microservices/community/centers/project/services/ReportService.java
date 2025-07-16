package com.microservicescommunitycenter.Microservices.community.centers.project.services;

import com.microservicescommunitycenter.Microservices.community.centers.project.models.CommunityCenter;
import com.microservicescommunitycenter.Microservices.community.centers.project.models.enums.ResourceType;
import com.microservicescommunitycenter.Microservices.community.centers.project.repositories.CommunityCenterRepository;
import com.microservicescommunitycenter.Microservices.community.centers.project.services.interfaces.IReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService implements IReport {

    @Autowired
    private CommunityCenterRepository repository;
    @Override
    public Map<ResourceType, Double> calculateAvarageResources() {
        List<CommunityCenter> centers = repository.findAll();

        Map<ResourceType, Double> media = new EnumMap<>(ResourceType.class);

        for (ResourceType tipo : ResourceType.values()) {
            double soma = centers.stream()
                    .mapToInt(c -> c.getRecurce().getOrDefault(tipo, 0))
                    .sum();
            media.put(tipo, soma / centers.size());
        }

        return media;
    }
}
