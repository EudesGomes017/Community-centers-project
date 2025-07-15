package com.microservicescommunitycenter.Microservices.community.centers.project.services.interfaces;

import com.microservicescommunitycenter.Microservices.community.centers.project.dtos.ResourceExchangeRequestDTO;
import com.microservicescommunitycenter.Microservices.community.centers.project.models.Negotiation;

public interface INegotiation {

    Negotiation carryNegotiation(ResourceExchangeRequestDTO dto);
}
