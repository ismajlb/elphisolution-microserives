package com.elphisolution.orderservice.service;

import com.elphisolution.orderservice.dto.OrderRequest;
import com.elphisolution.orderservice.mappers.OrderMapper;
import com.elphisolution.orderservice.model.Order;
import com.elphisolution.orderservice.model.OrderLineItems;
import com.elphisolution.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsList()
                .stream()
                .map(orderMapper::mapToDto)
                .toList();
        order.setOrderLineItemsList(orderLineItems);

        orderRepository.save(order);

    }
}
