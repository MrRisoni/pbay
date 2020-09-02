package pojos;

import models.items.Listings;

public class BasketItem {
    private Listings listedItem;
    private short quantity;


    public BasketItem(Listings listedItem, short quantity) {
        this.listedItem = listedItem;
        this.quantity = quantity;
    }


    public Listings getListedItem() {
        return listedItem;
    }

    public void setListedItem(Listings listedItem) {
        this.listedItem = listedItem;
    }

    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }
}
