package com.microservicescommunitycenter.Microservices.community.centers.project.services.interfaces;

import com.microservicescommunitycenter.Microservices.community.centers.project.dtos.CommunityCenterRequestDTO;
import com.microservicescommunitycenter.Microservices.community.centers.project.dtos.CommunityCenterResponseDTO;
import com.microservicescommunitycenter.Microservices.community.centers.project.dtos.OccupationCenterUpdateDTO;

import java.util.List;

public interface ICentroComunitario {

    CommunityCenterResponseDTO registerCenter(CommunityCenterRequestDTO dto);

    List<CommunityCenterResponseDTO> listAll();

    CommunityCenterResponseDTO findById(String id);

    CommunityCenterResponseDTO update(String id, CommunityCenterRequestDTO dto);

    CommunityCenterResponseDTO updateOccupation(String id, OccupationCenterUpdateDTO dto);

    void delete(String id);
}
