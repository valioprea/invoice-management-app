package invoicemanagementsystem.service;
import invoicemanagementsystem.entities.Invoice;
import invoicemanagementsystem.entities.Item;
import invoicemanagementsystem.entities.dto.InvoiceDTO;
import invoicemanagementsystem.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceService {

    private InvoiceRepository repository;

    public InvoiceService(InvoiceRepository repository) {
        this.repository = repository;
    }

    public List<Invoice> showAllInvoices() {
        return repository.findAll();
    }

    public Invoice storeInvoice(InvoiceDTO invoiceDTO){
        List<Item> mappedList = invoiceDTO.getItemList().stream()
                .map(itemDTO -> {
                    Item newItem = new Item();
                    newItem.setItemName(itemDTO.getItemName());
                    newItem.setItemQuantity(itemDTO.getItemQuantity());
                    newItem.setApplicableVAT(itemDTO.getApplicableVAT());
                    newItem.setPricePerUnitNoVAT(itemDTO.getPricePerUnitNoVAT());
                    newItem.setPricePerUnitWithVAT();
                    newItem.setPricePerQuantityNoVAT();
                    newItem.setPricePerQuantityWithVAT();
                    return newItem;
                }).collect(Collectors.toList());
        double sumVAT = 0;
        double sumNoVAT = 0;
        for (int i=0; i< mappedList.size(); i++){
            sumVAT = sumVAT + mappedList.get(i).getPricePerQuantityWithVAT();
            sumNoVAT = sumNoVAT + mappedList.get(i).getPricePerQuantityNoVAT();
        }
        Invoice invoice = new Invoice();
        invoice.setDate(invoiceDTO.getDate());
        invoice.setProviderName(invoiceDTO.getProviderName());
        invoice.setProviderAdress(invoiceDTO.getProviderAdress());
        invoice.setRegistrationCode(invoiceDTO.getRegistrationCode());
        invoice.setSocialCapital(invoiceDTO.getSocialCapital());
        invoice.setProviderCUI(invoiceDTO.getProviderCUI());
        invoice.setLegalForm(invoiceDTO.getLegalForm());
        invoice.setBeneficiaryName(invoiceDTO.getBeneficiaryName());
        invoice.setBeneficiaryAdress(invoiceDTO.getBeneficiaryAdress());
        invoice.setBeneficiaryCUI(invoiceDTO.getBeneficiaryCUI());
        for(Item item : mappedList) {
            invoice.setItem(item);
        }
        invoice.setTotalPriceNoVAT(sumNoVAT);
        invoice.setTotalPriceWithVAT(sumVAT);
        return repository.save(invoice);
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
