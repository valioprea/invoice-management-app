package invoicemanagementsystem.service;

import invoicemanagementsystem.entities.Invoice;
import invoicemanagementsystem.entities.Item;
import invoicemanagementsystem.entities.ItemInfo;
import invoicemanagementsystem.entities.dto.InvoiceDTO;
import invoicemanagementsystem.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

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

    public Invoice storeInvoice(InvoiceDTO invoice){

        List<Item> newItems = invoice.getItemList().stream().map(itemDTO -> {
            Item item = new Item();
            ItemInfo itemInfo = new ItemInfo();
            item.setItemName(itemDTO.getItemName());
            itemInfo.setPrice(itemDTO.getItemInfo().getPrice());
            itemInfo.setQuantity(itemDTO.getItemInfo().getQuantity());
            item.setItemInfo(itemInfo);
            return item;
        }).collect(Collectors.toList());

        Invoice newInvoice = new Invoice();
        newInvoice.setName(invoice.getName());

        for (Item item : newItems) {
            newInvoice.setItem(item);
        }

        newInvoice.setPriceWithoutVAT(invoice.getPriceWithoutVAT());
        newInvoice.setPriceWithVAT(invoice.getPriceWithVAT());
        newInvoice.setReceiverName(invoice.getReceiverName());
        return repository.save(newInvoice);
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
