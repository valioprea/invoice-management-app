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

    //Additional resulted values for calculation values, to round them up to two decimals
    private double pricePerUnitWithVAT_ROUNDED;
    private double pricePerQuantityNoVAT_ROUNDED;
    private double pricePerQuantityWithVAT_ROUNDED;

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



    //Additional SETTER Methods for calculated values, to round them up to two decimals
    public void setPricePerUnitWithVAT_ROUNDED(double pricePerUnitWithVAT){
        this.pricePerUnitWithVAT_ROUNDED = pricePerUnitWithVAT;
    }
    public void setPricePerQuantityNoVAT_ROUNDED(double pricePerQuantityNoVAT){
        this.pricePerQuantityNoVAT_ROUNDED = pricePerQuantityNoVAT;
    }
    public void setPricePerQuantityWithVAT_ROUNDED(double pricePerQuantityWithVAT){
        this.pricePerQuantityWithVAT_ROUNDED = pricePerQuantityWithVAT;
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

    //Additional getter methods for rounded values
    public double getPricePerUnitWithVAT_ROUNDED() {
        return pricePerUnitWithVAT_ROUNDED;
    }

    public double getPricePerQuantityNoVAT_ROUNDED() {
        return pricePerQuantityNoVAT_ROUNDED;
    }

    public double getPricePerQuantityWithVAT_ROUNDED() {
        return pricePerQuantityWithVAT_ROUNDED;
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
