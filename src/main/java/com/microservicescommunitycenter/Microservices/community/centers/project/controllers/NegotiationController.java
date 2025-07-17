package com.microservicescommunitycenter.Microservices.community.centers.project.controllers;

import com.microservicescommunitycenter.Microservices.community.centers.project.dtos.ResourceExchangeRequestDTO;
import com.microservicescommunitycenter.Microservices.community.centers.project.models.Negotiation;
import com.microservicescommunitycenter.Microservices.community.centers.project.services.NegotiationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/negotiations")
public class NegotiationController {

    @Autowired
    private NegotiationService service;

    @PostMapping
    public ResponseEntity<Negotiation> exchangeResources(@RequestBody @Valid ResourceExchangeRequestDTO dto) {
        Negotiation negotiation = service.carryNegotiation(dto);
        return ResponseEntity.ok(negotiation);
    }
}
