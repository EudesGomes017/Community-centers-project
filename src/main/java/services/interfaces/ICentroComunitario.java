package services.interfaces;

import dtos.CommunityCenterRequestDTO;
import dtos.CommunityCenterResponseDTO;

import java.util.List;

public interface ICentroComunitario {

    CommunityCenterResponseDTO registerCenter(CommunityCenterRequestDTO dto);

    List<CommunityCenterResponseDTO> listAll();
}
