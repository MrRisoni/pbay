package dtos;

import lombok.Data;
import models.orders.OrderStatuses;

import java.util.Date;

@Data
public class OrderItemTrackHistoryDto {
    private Date createdAt;
    private OrderStatusDto statusObj;

}
