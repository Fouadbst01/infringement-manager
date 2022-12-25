package com.example.registrationservicecommand.aggregates;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.Date;

@Aggregate
@Slf4j
public class VehicleRegistrationAggregate {
    @AggregateIdentifier
    private String vehicleId;
    private String registrationNum;
    private String brand;
    private String model;
    private int horsepower;
    private String ownerId;
    private String name;
    private Date birthDate;
}
