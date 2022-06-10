package invoicemanagementsystem.entities.dto;
import invoicemanagementsystem.entities.Item;
import java.util.List;

public class InvoiceDTO {
    private String name;
    private String receiverName;
    private List<ItemDTO> itemList;
    private int priceWithVAT;
    private int priceWithoutVAT;

    public InvoiceDTO(){}

    public InvoiceDTO(String name, String receiverName, List<ItemDTO> itemList, int priceWithVAT, int priceWithoutVAT) {
        this.name = name;
        this.receiverName = receiverName;
        this.itemList = itemList;
        this.priceWithVAT = priceWithVAT;
        this.priceWithoutVAT = priceWithoutVAT;
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

    public List<ItemDTO> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemDTO> itemList) {
        this.itemList = itemList;
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
