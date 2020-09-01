package pojos;

import models.general.Paymethods;
import models.users.BillingAddresses;
import models.users.ShippingAddresses;
import models.users.Users;

import java.util.List;

public class Basket {
    private BillingAddresses billTo;
    private ShippingAddresses shipTo;
    private Paymethods pay;
    private String currencyCode;
    private Users usr;
    private List<BasketItem> items;

    public Basket() {
    }


    public BillingAddresses getBillTo() {
        return billTo;
    }

    public void setBillTo(BillingAddresses billTo) {
        this.billTo = billTo;
    }

    public ShippingAddresses getShipTo() {
        return shipTo;
    }

    public void setShipTo(ShippingAddresses shipTo) {
        this.shipTo = shipTo;
    }

    public Paymethods getPay() {
        return pay;
    }

    public void setPay(Paymethods pay) {
        this.pay = pay;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Users getUsr() {
        return usr;
    }

    public void setUsr(Users usr) {
        this.usr = usr;
    }

    public List<BasketItem> getItems() {
        return items;
    }

    public void setItems(List<BasketItem> items) {
        this.items = items;
    }
}
