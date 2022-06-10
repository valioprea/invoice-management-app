package invoicemanagementsystem.entities.dto;


public class ItemInfoDTO {
    private int quantity;
    private int price;

    public ItemInfoDTO(){}

    public ItemInfoDTO(int quantity, int price) {
        this.quantity = quantity;
        this.price = price;
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
}
