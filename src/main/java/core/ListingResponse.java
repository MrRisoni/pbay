package core;

import java.math.BigInteger;

public class ListingResponse {

    private BigInteger itemSoldLately;

    public ListingResponse() {
    }

    public BigInteger getItemSoldLately() {
        return itemSoldLately;
    }

    public void setItemSoldLately(BigInteger itemSoldLately) {
        this.itemSoldLately = itemSoldLately;
    }
}
