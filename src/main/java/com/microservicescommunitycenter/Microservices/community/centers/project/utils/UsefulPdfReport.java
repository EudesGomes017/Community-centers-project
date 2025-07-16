package com.microservicescommunitycenter.Microservices.community.centers.project.utils;

import com.microservicescommunitycenter.Microservices.community.centers.project.models.CommunityCenter;

import java.io.OutputStream;
import java.util.List;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class UsefulPdfReport {

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
}
