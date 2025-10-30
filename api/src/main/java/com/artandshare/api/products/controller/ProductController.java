package com.artandshare.api.products.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.artandshare.api.products.model.Product;
import com.artandshare.api.products.service.ProductService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping("/products")
  public Iterable<Product> getProducts() {
    return productService.getProducts();
  }

  @GetMapping("/products/{id}")
  public Product getProduct(@PathVariable("id") final long id) {
    Optional<Product> product = productService.getProduct(id);
    if(product.isPresent()){
      return product.get();
    }else{
      return null;
    }
  }

  @PutMapping("/products/{id}")
  public Product changeDipoOeuvre(@PathVariable("id") final long id) {
    Optional<Product> product = productService.getProduct(id);
    if(product.isPresent()){
      Product productToChange = product.get();
      productToChange.setAvailable(!productToChange.getAvailable());
      Product updatedProduct = productService.saveProduct(productToChange);
      return updatedProduct;
    }else{
      return null;
    }
  }

  @PostMapping("/products")
  public Product creatProduct(@RequestBody Product product){
    return productService.saveProduct(product);
  }
  

}
