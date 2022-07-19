package invoicemanagementsystem.controller;

import invoicemanagementsystem.entities.dto.InvoiceDTO;
import invoicemanagementsystem.service.InvoiceService;
import invoicemanagementsystem.entities.Invoice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvoiceController {

    private InvoiceService service;

    public InvoiceController(InvoiceService service) {
        this.service = service;
    }

    //Show all invoices
    @GetMapping("/invoices")
    List<Invoice> showAll(){return service.showAllInvoices();}

    //Save an invoice
    @PostMapping("/invoice")
    Invoice saveInvoice(@RequestBody InvoiceDTO invoice) {return service.storeInvoice(invoice);};


    //Show invoice by Id
    @GetMapping("/invoice/{id}")
    Invoice getInvoiceById(@PathVariable Long id){return service.getInvoiceById(id);}

    //Delete invoice by Id
    @DeleteMapping("/invoice/{id}")
    String deleteInvoice(@PathVariable Long id){return service.deleteInvoice(id);}
}
