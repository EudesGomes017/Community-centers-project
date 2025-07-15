package com.microservicescommunitycenter.Microservices.community.centers.project.services.interfaces;

import com.microservicescommunitycenter.Microservices.community.centers.project.dtos.CommunityCenterRequestDTO;
import com.microservicescommunitycenter.Microservices.community.centers.project.dtos.CommunityCenterResponseDTO;

import java.util.List;

public interface ICentroComunitario {

    CommunityCenterResponseDTO registerCenter(CommunityCenterRequestDTO dto);

    List<CommunityCenterResponseDTO> listAll();
}
