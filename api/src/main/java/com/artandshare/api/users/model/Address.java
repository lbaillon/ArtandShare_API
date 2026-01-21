package com.artandshare.api.users.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Address {

    @Column(name = "street_number")
    private Integer number;

    @Column(name = "street_name")
    private String street;

    @Column(name = "postal_code")
    private Integer postalCode;

    @Column(name = "city")
    private String city;
}