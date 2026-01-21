package com.artandshare.api.orders.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artandshare.api.orders.model.Order;
import com.artandshare.api.orders.repository.OrderRepository;
import com.artandshare.api.products.model.Product;
import com.artandshare.api.products.repository.ProductRepository;
import com.artandshare.api.users.model.User;
import com.artandshare.api.users.repository.UserRepository;

import lombok.Data;

@Data
@Service
public class OrderService {
  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  ProductRepository productRepository;

  public Iterable<Order> getOrders() {
    return orderRepository.findAll();
  }

  public Optional<Order> getOrder(final long id) {
    return orderRepository.findById(id);
  }

  public Order saveOrder(Order order) {

    String userId = order.getUser().getId();

    if (userId == null) {
      throw new IllegalArgumentException("User or User ID must not be null");
    }

    Long productId = order.getProduct().getId();

    if (productId == null) {
      throw new IllegalArgumentException("Product or Product ID must not be null");
    }

    User user = userRepository.findById(userId)
        .orElseThrow(() -> new RuntimeException("User not found"));
    Product product = productRepository.findById(productId)
        .orElseThrow(() -> new RuntimeException("Product not found"));
    order.setUser(user);
    order.setProduct(product);
    Order savedOrder = orderRepository.save(order);
    return savedOrder;
  }

  public void deleteOrder(final long id) {
    orderRepository.deleteById(id);
  }
}
