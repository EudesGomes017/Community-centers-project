package com.microservicescommunitycenter.Microservices.community.centers.project.controllers;

import com.microservicescommunitycenter.Microservices.community.centers.project.models.CommunityCenter;
import com.microservicescommunitycenter.Microservices.community.centers.project.repositories.CommunityCenterRepository;
import com.microservicescommunitycenter.Microservices.community.centers.project.services.CommunityCenterService;
import com.microservicescommunitycenter.Microservices.community.centers.project.utils.UsefulPdfReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ControllerReport {

    @Autowired
    private CommunityCenterRepository repository;

    @GetMapping("/occupation/high/pdf")
    public void generateHighOccupancyReportInPDFformat(HttpServletResponse response) {
        try {

            List<CommunityCenter> centers = repository.findAll().stream()
                    .filter(c -> (double) c.getCurrentOccupation() / c.getMaximumCapacity() > 0.9)
                    .toList();
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=relatorio_ocupacao_alta.pdf");

            UsefulPdfReport.GenerateHighOccupationReport(centers, response.getOutputStream());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar PDF", e);
        }

    }
}
