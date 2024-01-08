package com.example.agentieturism;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;


import java.io.FileNotFoundException;

public class BiletGenerator {

    public static void generateBilet(String content, String numeFisier) {
        try {
            PdfDocument pdfDoc = new PdfDocument(new PdfWriter(numeFisier));
            Document document = new Document(pdfDoc);
            document.add(new Paragraph(content));
            document.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
