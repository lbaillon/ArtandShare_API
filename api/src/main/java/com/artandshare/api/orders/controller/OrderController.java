package com.artandshare.api.orders.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.artandshare.api.orders.model.Order;
import com.artandshare.api.orders.service.OrderService;

@RestController
public class OrderController {
  @Autowired
  private OrderService orderService;

  @GetMapping("/orders")
  public Iterable<Order> getOrders(){
    return orderService.getOrders();
  }

  @GetMapping("/orders/{id}")
  public Order getOrder(@PathVariable("id") final long id){
    Optional<Order> order = orderService.getOrder(id);
    if(order.isPresent()){
      return order.get();
    }else{
      return null;
    }
  }

  @PostMapping("/orders")
  public Order creatOrder(@RequestBody Order order){
    return orderService.saveOrder(order);
  }

  @DeleteMapping("/orders/{id}")
  public void deleteOrder(@PathVariable("id") final long id){
    orderService.deleteOrder(id);
  }
}
