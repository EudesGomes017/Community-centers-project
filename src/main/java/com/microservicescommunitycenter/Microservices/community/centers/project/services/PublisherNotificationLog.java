package com.microservicescommunitycenter.Microservices.community.centers.project.services;

import com.microservicescommunitycenter.Microservices.community.centers.project.models.CommunityCenter;
import com.microservicescommunitycenter.Microservices.community.centers.project.services.interfaces.INotificacaoPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PublisherNotificationLog implements INotificacaoPublisher {
    @Override
    public void publish(CommunityCenter center) {

        log.warn("🔔 Alerta: Centro '{}' atingiu a capacidade máxima de {} pessoas!",
                center.getName(), center.getMaximumCapacity());

    }
}
