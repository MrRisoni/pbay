package dtos;

import lombok.Data;

import models.general.Currencies;
import models.orders.OrderItems;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

@Data
public class OrderDto {

    private Long id;
    private String bankTransactionId;
    private Date createdAt;
    private BigDecimal total;
    private BigDecimal goodsTotal;
    private BigDecimal shipTotal;
    private BigDecimal fee;
    private short isSuccess;
    private short isVoid;

    private Collection<OrderItemDto> orderItemsCollection;
    private String currency_code;
}
