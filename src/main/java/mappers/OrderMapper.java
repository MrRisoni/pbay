package mappers;

import dtos.OrderDto;
import models.orders.Orders;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
public interface OrderMapper {


    OrderMapper MAPPER = Mappers.getMapper( OrderMapper.class );

    @Mapping(source = "id", target = "orderId")
    OrderDto fromOrder(Orders o);
}
