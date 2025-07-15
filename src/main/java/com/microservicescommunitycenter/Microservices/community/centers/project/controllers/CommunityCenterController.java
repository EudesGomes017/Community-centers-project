package com.microservicescommunitycenter.Microservices.community.centers.project.controllers;


import com.microservicescommunitycenter.Microservices.community.centers.project.dtos.CommunityCenterRequestDTO;
import com.microservicescommunitycenter.Microservices.community.centers.project.dtos.CommunityCenterResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.microservicescommunitycenter.Microservices.community.centers.project.services.CommunityCenterService;

import java.util.List;

@RestController
@RequestMapping("/api/centers")
@Tag(name = "Community Centers", description = "Operations related to Community Centers")
public class CommunityCenterController {

    @Autowired
    private CommunityCenterService service;

    @PostMapping
    @Operation(summary = "Salvar nova ", description = "Endpoint para criar uma nova vítima com ou sem imagem")
    public ResponseEntity<CommunityCenterResponseDTO> cadastrar(@RequestBody @Valid CommunityCenterRequestDTO dto) {
        CommunityCenterResponseDTO response = service.registerCenter(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<CommunityCenterResponseDTO>> listarTodos() {
        return ResponseEntity.ok(service.listAll());
    }
}
