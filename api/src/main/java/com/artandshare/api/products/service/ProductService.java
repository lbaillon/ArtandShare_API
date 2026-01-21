package com.artandshare.api.products.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artandshare.api.artists.model.Artist;
import com.artandshare.api.artists.repository.ArtistRepository;
import com.artandshare.api.products.model.Product;
import com.artandshare.api.products.repository.ProductRepository;

import lombok.Data;

@Data
@Service
public class ProductService {
  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private ArtistRepository artistRepository;

  public Optional<Product> getProduct(final long id){
    return productRepository.findById(id);
  }

  public Iterable<Product> getProducts(){
    return productRepository.findAll();
  }

    public Product saveProduct(Product product){
      Long id = product.getArtist().getId();
          if (id == null) {
        throw new IllegalArgumentException("Artist or Artist ID must not be null");
    }

        Artist artist = artistRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Artist not found"));

    product.setArtist(artist);
    Product savedProduct = productRepository.save(product);
    return savedProduct;
  }
}
