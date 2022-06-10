package invoicemanagementsystem.invoiceservice;

import invoicemanagementsystem.repository.Invoice;
import invoicemanagementsystem.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    private InvoiceRepository repository;

    public InvoiceService(InvoiceRepository repository) {
        this.repository = repository;
    }

    public List<Invoice> showAllInvoices() {
        return repository.findAll();
    }

    public Invoice storeInvoice(Invoice invoice){
        repository.save(invoice);
        return invoice;
    }

    public Invoice getInvoiceById(Long id){
        return repository.findById(id).orElse(null);
    }

    public String deleteInvoice(long id){
        if(repository.findById(id).isPresent()){
            repository.deleteById(id);
            return "Invoice with id "+id+" was deleted sucessfully";
        } else {
            return "No invoice was found with id "+id;
        }
    }

}
