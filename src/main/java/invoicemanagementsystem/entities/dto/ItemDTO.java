package invoicemanagementsystem.entities.dto;

public class ItemDTO {

    //Details for each purchased item
    private String itemName;
    private double itemQuantity;
    private double applicableVAT;
    private double pricePerUnitNoVAT;

    //Getter methods to map the actual entity

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

    @Override
    public String toString() {
        return "ItemDTO{" +
                "itemName='" + itemName + '\'' +
                ", itemQuantity=" + itemQuantity +
                ", applicableVAT=" + applicableVAT +
                ", pricePerUnitNoVAT=" + pricePerUnitNoVAT +
                '}';
    }
}
