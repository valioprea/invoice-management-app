package invoicemanagementsystem.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String receiverName;
    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Item> itemList = new ArrayList<>();
    private int priceWithVAT;
    private int priceWithoutVAT;

    public Invoice() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    //to attach Items to the invoice's item list
    public void setItem(Item item) {
        this.itemList.add(item);
        item.setInvoice(this);
    }

    //OPTIONAL - for further development: to delete items from the list from the invoice
    public void deleteItem(Item item) {
        this.itemList.remove(item);
        item.setInvoice(null);
    }

    public int getPriceWithVAT() {
        return priceWithVAT;
    }

    public void setPriceWithVAT(int priceWithVAT) {
        this.priceWithVAT = priceWithVAT;
    }

    public int getPriceWithoutVAT() {
        return priceWithoutVAT;
    }

    public void setPriceWithoutVAT(int priceWithoutVAT) {
        this.priceWithoutVAT = priceWithoutVAT;
    }

}
