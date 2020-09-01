package pojos;

import models.items.Listings;

public class BasketItem {
    private Listings listedItem;
    private int quantity;


    public BasketItem(Listings listedItem, int quantity) {
        this.listedItem = listedItem;
        this.quantity = quantity;
    }


    public Listings getListedItem() {
        return listedItem;
    }

    public void setListedItem(Listings listedItem) {
        this.listedItem = listedItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
