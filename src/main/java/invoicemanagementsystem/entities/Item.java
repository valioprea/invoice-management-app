package invoicemanagementsystem.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item {

    @Id @GeneratedValue
    private Long id;
    private String itemName;

    @OneToOne(mappedBy = "item", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JsonManagedReference
    private ItemInfo itemInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Invoice invoice;

    public Item(){}

    public Item(Long id, String itemName, ItemInfo itemInfo) {
        this.id = id;
        this.itemName = itemName;
        this.itemInfo = itemInfo;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public ItemInfo getItemInfo() {
        return itemInfo;
    }

    public void setItemInfo(ItemInfo itemInfo) {
        this.itemInfo = itemInfo;
        itemInfo.setItem(this);
    }
}
