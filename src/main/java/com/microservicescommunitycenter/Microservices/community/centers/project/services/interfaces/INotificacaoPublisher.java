package com.microservicescommunitycenter.Microservices.community.centers.project.services.interfaces;

import com.microservicescommunitycenter.Microservices.community.centers.project.models.CommunityCenter;

public interface INotificacaoPublisher {

    void publish(CommunityCenter center);
}
