package com.microservicescommunitycenter.Microservices.community.centers.project.servicesTests;


import com.microservicescommunitycenter.Microservices.community.centers.project.dtos.CommunityCenterRequestDTO;
import com.microservicescommunitycenter.Microservices.community.centers.project.dtos.CommunityCenterResponseDTO;
import com.microservicescommunitycenter.Microservices.community.centers.project.dtos.OccupationCenterUpdateDTO;
import com.microservicescommunitycenter.Microservices.community.centers.project.models.CommunityCenter;
import com.microservicescommunitycenter.Microservices.community.centers.project.repositories.CommunityCenterRepository;
import com.microservicescommunitycenter.Microservices.community.centers.project.services.CommunityCenterService;
import com.microservicescommunitycenter.Microservices.community.centers.project.services.exceotionsServices.ResourceNotFoundException;
import com.microservicescommunitycenter.Microservices.community.centers.project.services.interfaces.INotificacaoPublisher;
import com.microservicescommunitycenter.Microservices.community.centers.project.utils.Factory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class ServiceCommunityCenterTest {

    @InjectMocks
    private CommunityCenterService communityCenterService;

    @Mock
    private CommunityCenterRepository repository;

    @Mock
    private INotificacaoPublisher notificacaoPublisher;

    CommunityCenter communityCenter;
    CommunityCenterRequestDTO request;
    OccupationCenterUpdateDTO occupationCenterUpdateDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        request = Factory.createCenterRequest();
        CommunityCenter mockCentro = Factory.createCenter("abc123", request.getName(), 200, 50);

        occupationCenterUpdateDTO = Factory.createUpdateOccupationDTO(50);

        when(repository.save(any())).thenReturn(mockCentro);
        when(repository.findById("999")).thenReturn(Optional.empty());
    }

    @Test
    void shouldCreateCenterSuccessfully() {

        CommunityCenterResponseDTO response = communityCenterService.registerCenter(request);

        assertNotNull(response);
        assertEquals("Centro Alpha", response.getName());
        verify(repository, times(1)).save(any());
    }

    @Test
    void shouldThrowExceptionWhenCentralDoesNotExist() {

        ResourceNotFoundException ex = assertThrows(ResourceNotFoundException.class, () -> {
            communityCenterService.updateOccupation("999", occupationCenterUpdateDTO);
        });

        assertEquals("Centro não encontrado", ex.getMessage());
    }
}
