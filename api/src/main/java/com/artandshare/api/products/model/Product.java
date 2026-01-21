package com.artandshare.api.products.model;

import java.util.List;

import com.artandshare.api.artists.model.Artist;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "products")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "artist_id", nullable = false)
    private  Artist artist;

    private String description;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
        name = "product_photos", // nom de la table associée
        joinColumns = @JoinColumn(name = "product_id") // clé étrangère vers la table users
    )
    @Column(name = "photo_url")
    private List<String> photos;

    private String theme;

    private String type;

    private Float value;

    private Boolean purchaseOption;

    private Boolean available;


}
