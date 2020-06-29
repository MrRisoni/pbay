package core;

import entities.Country;

import java.math.BigInteger;
import java.util.ArrayList;

public class ListingResponse {

    private BigInteger itemSoldLately = BigInteger. valueOf(0);
    private BigInteger totalBidsLately = BigInteger. valueOf(0);
    private float bestBid;
    private int minutesAgo;
    private ArrayList<String> shipsFrom ;
    private boolean isAuction;
    private String productCurrency;
    private float productPrice;
    private float avgShipCost;
    private ArrayList<Country> doesNotShipTo;

    public ListingResponse() {
        this.shipsFrom = new ArrayList<>();
        this.doesNotShipTo = new ArrayList<>();

    }

    public BigInteger getTotalBidsLately() {
        return totalBidsLately;
    }

    public void setTotalBidsLately(BigInteger totalBidsLately) {
        this.totalBidsLately = totalBidsLately;
    }

    public BigInteger getItemSoldLately() {
        return itemSoldLately;
    }

    public void setItemSoldLately(BigInteger itemSoldLately) {
        this.itemSoldLately = itemSoldLately;
    }

    public float getBestBid() {
        return bestBid;
    }

    public void setBestBid(float bestBid) {
        this.bestBid = bestBid;
    }

    public int getMinutesAgo() {
        return minutesAgo;
    }

    public void setMinutesAgo(int minutesAgo) {
        this.minutesAgo = minutesAgo;
    }

    public ArrayList<String> getShipsFrom() {
        return shipsFrom;
    }

    public void setShipsFrom(ArrayList<String> shipsFrom) {
        this.shipsFrom = shipsFrom;
    }

    public boolean isAuction() {
        return isAuction;
    }

    public void setAuction(boolean auction) {
        isAuction = auction;
    }

    public String getProductCurrency() {
        return productCurrency;
    }

    public void setProductCurrency(String productCurrency) {
        this.productCurrency = productCurrency;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public float getAvgShipCost() {
        return avgShipCost;
    }

    public void setAvgShipCost(float avgShipCost) {
        this.avgShipCost = avgShipCost;
    }

    public ArrayList<Country> getDoesNotShipTo() {
        return doesNotShipTo;
    }

    public void setDoesNotShipTo(ArrayList<Country> doesNotShipTo) {
        this.doesNotShipTo = doesNotShipTo;
    }
}
