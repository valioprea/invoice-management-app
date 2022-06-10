package invoicemanagementsystem.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class ItemInfo {

    @Id
    @GeneratedValue
    private Long id;
    private int quantity;
    private int price;

    @OneToOne
    @JsonBackReference
    private Item item;

    public ItemInfo(){}

    public ItemInfo(Long id, int quantity, int price, Item item) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.item = item;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
