package com.artandshare.api.products.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.artandshare.api.products.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

}
