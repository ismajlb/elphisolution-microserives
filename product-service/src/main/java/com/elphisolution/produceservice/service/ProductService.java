package com.elphisolution.produceservice.service;

import com.elphisolution.produceservice.dto.ProductRequest;
import com.elphisolution.produceservice.dto.ProductResponse;
import com.elphisolution.produceservice.mapper.ProductMapper;
import com.elphisolution.produceservice.model.Product;
import com.elphisolution.produceservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(productMapper::mapToProductResponse)
                .collect(Collectors.toList());
    }

}
