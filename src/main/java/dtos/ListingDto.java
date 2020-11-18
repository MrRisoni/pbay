package dtos;

import lombok.Data;
import models.general.Currencies;
import models.sellers.Selling;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ListingDto {
    private Long id;
    private BigDecimal price;
    private BigDecimal feeEuro;
    private Date activeFrom;
    private Date activeUntil;
    private short numWatchers;
    private short isAuction;
    private CurrencyDto currencyObj;
    private SellingDto sellingObj;
    private int totalBids;
}
