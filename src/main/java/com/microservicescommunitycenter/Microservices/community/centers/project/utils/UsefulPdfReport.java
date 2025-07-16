package com.microservicescommunitycenter.Microservices.community.centers.project.utils;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.microservicescommunitycenter.Microservices.community.centers.project.models.CommunityCenter;
import com.microservicescommunitycenter.Microservices.community.centers.project.models.Negotiation;
import com.microservicescommunitycenter.Microservices.community.centers.project.models.enums.ResourceType;
import com.microservicescommunitycenter.Microservices.community.centers.project.repositories.CommunityCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.OutputStream;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;


public class UsefulPdfReport {

    @Autowired
    private static CommunityCenterRepository communityCenterRepository;

    public static void GenerateHighOccupationReport(List<CommunityCenter> center, OutputStream out) throws Exception {

        Document document = new Document();
        PdfWriter.getInstance(document, out);
        document.open();

        document.add(new Paragraph("Relatório de Centros com Ocupação > 90%"));
        document.add(new Paragraph(" "));

        PdfPTable table = new PdfPTable(4);
        table.addCell("Nome");
        table.addCell("Endereço");
        table.addCell("Capacidade Máxima");
        table.addCell("Ocupação Atual");

        for (CommunityCenter c : center) {
            table.addCell(c.getName());
            table.addCell(c.getAddress());
            table.addCell(String.valueOf(c.getMaximumCapacity()));
            table.addCell(String.valueOf(c.getCurrentOccupation()));
        }

        document.add(table);
        document.close();
    }

    public static void GenerateReportMediaResources(Map<ResourceType, Double> mediaByResource, OutputStream out) throws Exception {
        Document document = new Document();
        PdfWriter.getInstance(document, out);
        document.open();

        document.add(new Paragraph("Relatório de Média de Recursos por Centro"));
        document.add(new Paragraph(" "));

        PdfPTable table = new PdfPTable(2);
        table.addCell("Tipo de Recurso");
        table.addCell("Média por Centro");

        for (Map.Entry<ResourceType, Double> entry : mediaByResource.entrySet()) {
            table.addCell(entry.getKey().name());
            table.addCell(String.format("%.2f", entry.getValue()));

        }

        document.add(table);
        document.close();
    }

    public static void generateNegotiationsReport(List<Negotiation> negotiations, OutputStream out) throws Exception {

        Document document = new Document();
        PdfWriter.getInstance(document, out);
        document.open();

        document.add(new Paragraph("Histórico de Negociações"));
        document.add(new Paragraph(" "));

        PdfPTable table = new PdfPTable(5);
        table.addCell("Data/Hora");
        table.addCell("Centro Origem");
        table.addCell("Centro Destino");
        table.addCell("Recursos Enviados (Origem)");
        table.addCell("Recursos Enviados (Destino)");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        for (Negotiation n : negotiations) {
            table.addCell(n.getDateTime().format(formatter));
            table.addCell(n.getOriginCenterId());
            table.addCell(n.getDestinationCenterId());
            table.addCell(n.getResourcesSubmittedOrigin().toString());
            table.addCell(n.getResourcesSentDestination().toString());
        }

        document.add(table);
        document.close();

    }


}
