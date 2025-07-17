package com.microservicescommunitycenter.Microservices.community.centers.project.controllerTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservicescommunitycenter.Microservices.community.centers.project.controllers.CommunityCenterController;
import com.microservicescommunitycenter.Microservices.community.centers.project.dtos.CommunityCenterRequestDTO;
import com.microservicescommunitycenter.Microservices.community.centers.project.dtos.CommunityCenterResponseDTO;
import com.microservicescommunitycenter.Microservices.community.centers.project.services.CommunityCenterService;
import com.microservicescommunitycenter.Microservices.community.centers.project.utils.Factory;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CommunityCenterController.class)
public class CommunityCenterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CommunityCenterService communityCenterService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void sholdCenterPOST() throws Exception {
        CommunityCenterRequestDTO request = Factory.createCenterRequest();
        CommunityCenterResponseDTO response = CommunityCenterResponseDTO.builder()
                .id("123")
                .name(request.getName())
                .address(request.getAddress())
                .latitude(request.getLatitude())
                .longitude(request.getLongitude())
                .maximumCapacity(request.getMaximumCapacity())
                .CurrentOccupation(request.getCurrentOccupation())
                .recurce(request.getRecurce())
                .build();

        Mockito.when(communityCenterService.registerCenter(any())).thenReturn(response);

        mockMvc.perform(post("/api/centers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("123"))
                .andExpect(jsonPath("$.name").value("Centro Alpha"));
    }

    @Test
    void sholdValidateInvalidRequest() throws Exception {
        CommunityCenterRequestDTO request = new CommunityCenterRequestDTO();

        mockMvc.perform(post("/api/centers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message", containsString("Erro de validação")));
    }
}
