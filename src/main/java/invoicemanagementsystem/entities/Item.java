package invoicemanagementsystem.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item {

    //Unique ID for each item on the list
    @Id
    @GeneratedValue
    private Long itemId;

    //Logical link of each item to it's invoice
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Invoice invoice;

    //Details for each purchased item from CLIENT side
    private String itemName;
    private double itemQuantity;
    private double applicableVAT;
    private double pricePerUnitNoVAT;

    // Resulted Values
    private double pricePerUnitWithVAT;
    private double pricePerQuantityNoVAT;
    private double pricePerQuantityWithVAT;

    //Setter Methods
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemQuantity(double itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public void setApplicableVAT(double applicableVAT) {
        this.applicableVAT = applicableVAT;
    }

    public void setPricePerUnitNoVAT(double pricePerUnitNoVAT) {
        this.pricePerUnitNoVAT = pricePerUnitNoVAT;
    }

    public void setPricePerUnitWithVAT() {
        this.pricePerUnitWithVAT = this.pricePerUnitNoVAT + applicableVAT*this.pricePerUnitNoVAT;
    }

    public void setPricePerQuantityNoVAT() {
        this.pricePerQuantityNoVAT = this.itemQuantity*this.pricePerUnitNoVAT;
    }

    public void setPricePerQuantityWithVAT() {
        this.pricePerQuantityWithVAT = this.itemQuantity*pricePerUnitWithVAT;
    }

    //Getter methods
    public double getPricePerQuantityNoVAT() {
        return pricePerQuantityNoVAT;
    }

    public double getPricePerQuantityWithVAT() {
        return pricePerQuantityWithVAT;
    }

    public Long getItemId() {
        return itemId;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemQuantity() {
        return itemQuantity;
    }

    public double getApplicableVAT() {
        return applicableVAT;
    }

    public double getPricePerUnitNoVAT() {
        return pricePerUnitNoVAT;
    }

    public double getPricePerUnitWithVAT() {
        return pricePerUnitWithVAT;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", invoice=" + invoice +
                ", itemName='" + itemName + '\'' +
                ", itemQuantity=" + itemQuantity +
                ", applicableVAT=" + applicableVAT +
                ", pricePerUnitNoVAT=" + pricePerUnitNoVAT +
                ", pricePerUnitWithVAT=" + pricePerUnitWithVAT +
                ", pricePerQuantityNoVAT=" + pricePerQuantityNoVAT +
                ", pricePerQuantityWithVAT=" + pricePerQuantityWithVAT +
                '}';
    }
}
