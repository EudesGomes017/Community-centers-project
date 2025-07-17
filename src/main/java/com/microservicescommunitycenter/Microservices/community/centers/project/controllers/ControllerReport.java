package com.microservicescommunitycenter.Microservices.community.centers.project.controllers;

import com.microservicescommunitycenter.Microservices.community.centers.project.models.CommunityCenter;
import com.microservicescommunitycenter.Microservices.community.centers.project.models.Negotiation;
import com.microservicescommunitycenter.Microservices.community.centers.project.models.enums.ResourceType;
import com.microservicescommunitycenter.Microservices.community.centers.project.repositories.CommunityCenterRepository;
import com.microservicescommunitycenter.Microservices.community.centers.project.repositories.RepositoryNegotiation;
import com.microservicescommunitycenter.Microservices.community.centers.project.services.interfaces.IReport;
import com.microservicescommunitycenter.Microservices.community.centers.project.utils.UsefulPdfReport;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/reports")
public class ControllerReport {

    @Autowired
    private CommunityCenterRepository repository;

    @Autowired
    private RepositoryNegotiation repositoryNegotiation;

    @Autowired
    private IReport iReport;

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

    @GetMapping("/average/recurse/pdf")
    public void GenerateMediaResourcesPDF(HttpServletResponse response) {

        try {
            Map<ResourceType, Double> average = iReport.calculateAvarageResources();

            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=relatorio_media_recursos.pdf");

            UsefulPdfReport.GenerateReportMediaResources(average, response.getOutputStream());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar PDF", e);
        }
    }

    @GetMapping("/negotiations/pdf")
    public void gerarHistoricoNegociacoesPDF(
            @RequestParam String centroId,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy.MM.dd") LocalDate since,
            HttpServletResponse response) {

        try {
            LocalDateTime initial = (since != null) ? since.atStartOfDay(): LocalDateTime.MIN;
            LocalDateTime finish = LocalDateTime.now();

            List<Negotiation> negotiations = repositoryNegotiation.findAll().stream()
                    .filter(n -> (n.getOriginCenterId().equals(centroId) || n.getDestinationCenterId().equals(centroId)))
                    .filter(n -> !n.getDateTime().isBefore(initial) && !n.getDateTime().isAfter(finish))
                    .toList();

            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=relatorio_negociacoes_" + centroId + ".pdf");

            UsefulPdfReport.generateNegotiationsReport(negotiations, response.getOutputStream());

        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar PDF", e);
        }

    }
}



