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
    @Operation(summary = "Salvar nova ", description = "Endpoint to create a new Community Center")
    public ResponseEntity<CommunityCenterResponseDTO> register(@RequestBody @Valid CommunityCenterRequestDTO dto) {
        CommunityCenterResponseDTO response = service.registerCenter(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<CommunityCenterResponseDTO>> listAll() {
        return ResponseEntity.ok(service.listAll());
    }

    @GetMapping(value = "/id/{id}", produces = "application/json")
    public ResponseEntity<CommunityCenterResponseDTO> findById(@PathVariable("id") String id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping(value = "/update/{id}", produces = "application/json")
    public ResponseEntity<CommunityCenterResponseDTO> update(
            @PathVariable String id,
            @RequestBody @Valid CommunityCenterRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping(value = "/delet/{id}", produces = "application/json")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
