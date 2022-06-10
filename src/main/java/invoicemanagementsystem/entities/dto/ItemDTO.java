package invoicemanagementsystem.entities.dto;

import invoicemanagementsystem.entities.ItemInfo;


public class ItemDTO {
    private String itemName;
    private ItemInfoDTO itemInfo;

    public ItemDTO(){}

    public ItemDTO(String itemName, ItemInfoDTO itemInfo) {
        this.itemName = itemName;
        this.itemInfo = itemInfo;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public ItemInfoDTO getItemInfo() {
        return itemInfo;
    }

    public void setItemInfo(ItemInfoDTO itemInfo) {
        this.itemInfo = itemInfo;
    }
}
