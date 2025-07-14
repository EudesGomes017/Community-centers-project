package services;

import dtos.CommunityCenterRequestDTO;
import dtos.CommunityCenterResponseDTO;
import org.springframework.stereotype.Service;
import services.interfaces.ICentroComunitario;

import java.util.List;

@Service
public class CentroComunitarioService implements ICentroComunitario {
    @Override
    public CommunityCenterResponseDTO registerCenter(CommunityCenterRequestDTO dto) {
        Com
    }

    @Override
    public List<CommunityCenterResponseDTO> listAll() {
        return List.of();
    }
}
