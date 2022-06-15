package invoicemanagementsystem.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import invoicemanagementsystem.entities.Invoice;
import invoicemanagementsystem.service.InvoiceService;
import invoicemanagementsystem.service.PdfGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class PDFExportController {

    @Autowired
    InvoiceService invoiceService;
    private final PdfGeneratorService pdfService;

    public PDFExportController(PdfGeneratorService service) {
        this.pdfService = service;
    }

    @GetMapping("/invoice/{id}/print")
    public void generatePDF(HttpServletResponse response, @PathVariable Long id) throws IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=pdf_"+currentDateTime+".pdf";
        response.setHeader(headerKey, headerValue);

        Invoice invoice = invoiceService.getInvoiceById(id);
        ObjectMapper obj = new ObjectMapper();
        try {
            String jsonStr = obj.writeValueAsString(invoice);
            this.pdfService.export(response, jsonStr);
            System.out.println(jsonStr);
        } catch(JsonProcessingException e) {
            System.out.println(e.getMessage());
            response.setStatus(404);
        }
    }

    @GetMapping("invoice/printall")
    public void generatePDF(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=pdf_"+currentDateTime+".pdf";
        response.setHeader(headerKey, headerValue);

        List<Invoice> invoices = invoiceService.showAllInvoices();
        ObjectMapper obj = new ObjectMapper();
        try {
            String jsonStr = obj.writeValueAsString(invoices);
            this.pdfService.export(response, jsonStr);
            System.out.println(jsonStr);
        } catch(JsonProcessingException e) {
            System.out.println(e.getMessage());
            response.setStatus(404);
        }
    }


}
