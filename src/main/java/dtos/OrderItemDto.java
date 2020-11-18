package dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Collection;

@Data
public class OrderItemDto {
    private Long id;
    private short quantity;
    private String trackingNums;
    private BigDecimal total;
    private BigDecimal goodsTotal;
    private BigDecimal shipTotal;
    private BigDecimal rate;
    private short isVoid;
    private String currency_code;
    private SellingDto itemObj;
    private OrderStatusDto statusObj;
    private Collection<OrderItemTrackHistoryDto> orderItemTrackHistoryCollection;


}
