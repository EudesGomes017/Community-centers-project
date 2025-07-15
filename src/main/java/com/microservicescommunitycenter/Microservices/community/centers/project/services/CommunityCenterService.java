package com.microservicescommunitycenter.Microservices.community.centers.project.services;

import com.microservicescommunitycenter.Microservices.community.centers.project.dtos.CommunityCenterRequestDTO;
import com.microservicescommunitycenter.Microservices.community.centers.project.dtos.CommunityCenterResponseDTO;
import com.microservicescommunitycenter.Microservices.community.centers.project.dtos.convert.CommunityCenterMapper;
import com.microservicescommunitycenter.Microservices.community.centers.project.models.CommunityCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.microservicescommunitycenter.Microservices.community.centers.project.repositories.CommunityCenterRepository;
import com.microservicescommunitycenter.Microservices.community.centers.project.services.interfaces.ICentroComunitario;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommunityCenterService implements ICentroComunitario {

    @Autowired
    private CommunityCenterRepository repository;


    @Transactional
    @Override
    public CommunityCenterResponseDTO registerCenter(CommunityCenterRequestDTO dto) {
        CommunityCenter center = CommunityCenterMapper.toEntity(dto);
        CommunityCenter salve = repository.save(center);
        return CommunityCenterMapper.toDTO(salve);
    }

    @Transactional(readOnly = true)
    @Override
    public List<CommunityCenterResponseDTO> listAll() {
        return repository.findAll()
                .stream()
                .map(CommunityCenterMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CommunityCenterResponseDTO findById(String id) {
        CommunityCenter center = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Centro não encontrado"));
        return CommunityCenterMapper.toDTO(center);
    }


    @Override
    public CommunityCenterResponseDTO update(String id, CommunityCenterRequestDTO dto) {
        CommunityCenter center = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Centro não encontrado"));

        center.setName(dto.getName());
        center.setAddress(dto.getAddress());
        center.setLatitude(dto.getLatitude());
        center.setLongitude(dto.getLongitude());
        center.setMaximumCapacity(dto.getMaximumCapacity());
        center.setCurrentOccupation(dto.getCurrentOccupation());
        center.setRecurce(dto.getRecurce());

        CommunityCenter resultUpdate = repository.save(center);

        return CommunityCenterMapper.toDTO(resultUpdate);
    }

    @Override
    public void delete(String id) {
        CommunityCenter center = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Centro não encontrado"));

        repository.delete(center);
    }
}
