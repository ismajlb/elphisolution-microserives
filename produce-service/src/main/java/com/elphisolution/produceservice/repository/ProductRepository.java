package com.elphisolution.produceservice.repository;

import com.elphisolution.produceservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
