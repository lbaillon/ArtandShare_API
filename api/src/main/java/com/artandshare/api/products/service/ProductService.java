package com.artandshare.api.products.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artandshare.api.products.model.Product;
import com.artandshare.api.products.repository.ProductRepository;

import lombok.Data;

@Data
@Service
public class ProductService {
  @Autowired
  private ProductRepository productRepository;

  public Optional<Product> getProduct(final long id){
    return productRepository.findById(id);
  }

  public Iterable<Product> getProducts(){
    return productRepository.findAll();
  }

    public Product saveProduct(Product product){
    Product savedProduct = productRepository.save(product);
    return savedProduct;
  }
}
