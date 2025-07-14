package controllers;


import dtos.CommunityCenterRequestDTO;
import dtos.CommunityCenterResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.CommunityCenterService;

import java.util.List;

@RestController
@RequestMapping("/api/center")
public class CommunityCenterController {

    @Autowired
    private CommunityCenterService service;



    @PostMapping
    public ResponseEntity<CommunityCenterResponseDTO> cadastrar(@RequestBody @Valid CommunityCenterRequestDTO dto) {
        CommunityCenterResponseDTO response = service.registerCenter(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<CommunityCenterResponseDTO>> listarTodos() {
        return ResponseEntity.ok(service.listAll());
    }
}
