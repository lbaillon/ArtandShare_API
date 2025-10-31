package com.artandshare.api.orders.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artandshare.api.orders.model.Order;
import com.artandshare.api.orders.repository.OrderRepository;

import lombok.Data;

@Data
@Service
public class OrderService {
  @Autowired
  private OrderRepository orderRepository;

  public Iterable<Order> getOrders(){
    return orderRepository.findAll();
  }

  public Optional<Order> getOrder(final long id){
    return orderRepository.findById(id);
  }

  public Order saveOrder(Order order){
    Order savedOrder = orderRepository.save(order);
    return savedOrder;
  }

  public void deleteOrder(final long id) {
    orderRepository.deleteById(id);
  }
}
