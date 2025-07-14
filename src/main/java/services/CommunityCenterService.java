package services;

import dtos.CommunityCenterRequestDTO;
import dtos.CommunityCenterResponseDTO;
import dtos.convert.CommunityCenterMapper;
import models.CommunityCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.CommunityCenterRepository;
import services.interfaces.ICentroComunitario;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommunityCenterService implements ICentroComunitario {

    @Autowired
    private CommunityCenterRepository repository;


    @Override
    public CommunityCenterResponseDTO registerCenter(CommunityCenterRequestDTO dto) {
        CommunityCenter center = CommunityCenterMapper.toEntity( dto);
        CommunityCenter salve =  repository.save(center);
        return CommunityCenterMapper.toDTO(salve);
    }

    @Override
    public List<CommunityCenterResponseDTO> listAll() {
        return repository.findAll()
                .stream()
                .map(CommunityCenterMapper::toDTO)
                .collect(Collectors.toList());
    }
}
