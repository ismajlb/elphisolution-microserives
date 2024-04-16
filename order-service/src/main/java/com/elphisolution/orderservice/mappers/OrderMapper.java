package com.elphisolution.orderservice.mappers;

import com.elphisolution.orderservice.dto.OrderLineItemsDto;
import com.elphisolution.orderservice.model.Order;
import com.elphisolution.orderservice.model.OrderLineItems;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {

        return OrderLineItems.builder()
                .price(orderLineItemsDto.getPrice())
                .skuCode(orderLineItemsDto.getSkuCode())
                .quantity(orderLineItemsDto.getQuantity())
                .build();
    }
}
