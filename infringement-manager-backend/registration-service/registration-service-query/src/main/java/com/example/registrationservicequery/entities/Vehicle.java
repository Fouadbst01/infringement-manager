package com.example.registrationservicequery.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Vehicle {
    @Id
    private String id;
    private String registrationNum;
    private String brand;
    private String model;
    private int horsepower;
    @ManyToOne
    private Owner owner;
}
