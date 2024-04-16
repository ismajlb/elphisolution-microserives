package com.elphisolution.produceservice.mapper;

import com.elphisolution.produceservice.dto.ProductResponse;
import com.elphisolution.produceservice.model.Product;
import org.springframework.stereotype.Component;


@Component
public class ProductMapper {
    public ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
