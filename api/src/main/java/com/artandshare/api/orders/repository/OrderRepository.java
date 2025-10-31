package com.artandshare.api.orders.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.artandshare.api.orders.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long>{

  
}
