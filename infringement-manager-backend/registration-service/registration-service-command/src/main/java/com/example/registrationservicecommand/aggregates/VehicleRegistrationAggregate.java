package com.example.registrationservicecommand.aggregates;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.sid.coreapi.command.CreateVehicleCommand;
import org.sid.coreapi.command.UpdateVehicleOwnerCommand;
import org.sid.coreapi.events.CreatedRadarEvent;
import org.sid.coreapi.events.CreatedVehicleEvent;
import org.sid.coreapi.events.UpdateVehicleOwnerEvent;

import java.util.Date;

@Aggregate
@Slf4j
@NoArgsConstructor
public class VehicleRegistrationAggregate {
    @AggregateIdentifier
    private String registrationNum;
    private String brand;
    private String model;
    private int horsepower;
    private String ownerCIN;
    private String ownername;
    private Date ownerbirthDate;

    @CommandHandler
    public VehicleRegistrationAggregate(CreateVehicleCommand createVehicleCommand){
        log.info("CreateVehicleCommand received");
        AggregateLifecycle.apply(new CreatedVehicleEvent(
            createVehicleCommand.getId(),
            createVehicleCommand.getPayload()
        ));
    }

    @CommandHandler
    public void handel(UpdateVehicleOwnerCommand updateVehicleOwnerCommand){
        log.info("UpdateVehicleOwnerCommand received");
        AggregateLifecycle.apply(new UpdateVehicleOwnerEvent(
            updateVehicleOwnerCommand.getId(),
            updateVehicleOwnerCommand.getPayload()
        ));
    }

    @EventSourcingHandler
    public void on(CreatedVehicleEvent event){
        log.info("CreatedVehicleEvent occurred");
        this.registrationNum = event.getId();
        this.brand= event.getPayload().getBrand();
        this.model= event.getPayload().getModel();
        this.horsepower= event.getPayload().getHorsepower();
        this.ownerCIN= event.getPayload().getOwnerCIN();
        this.ownername= event.getPayload().getOwnerName();
        this.ownerbirthDate= event.getPayload().getOwnerBirthDate();
    }

    @EventSourcingHandler
    public void on(UpdateVehicleOwnerEvent event){
        log.info("UpdateVehicleOwnerEvent occurred");
        this.ownerCIN= event.getPayload().getOwnerCIN();
        this.ownername= event.getPayload().getOwnerName();
        this.ownerbirthDate= event.getPayload().getOwnerBirthDate();
    }
}
