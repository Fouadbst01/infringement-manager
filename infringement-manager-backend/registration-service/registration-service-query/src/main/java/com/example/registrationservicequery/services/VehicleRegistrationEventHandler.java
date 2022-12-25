package com.example.registrationservicequery.services;

import com.example.registrationservicequery.entities.Owner;
import com.example.registrationservicequery.entities.Vehicle;
import com.example.registrationservicequery.repositories.OwnerRepository;
import com.example.registrationservicequery.repositories.VehicleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.gateway.EventGateway;
import org.sid.coreapi.events.CreatedVehicleEvent;
import org.sid.coreapi.events.UpdateVehicleOwnerEvent;
import org.sid.exceptions.OwnerNotFoundException;
import org.sid.exceptions.VehicleNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@Transactional
@AllArgsConstructor
public class VehicleRegistrationEventHandler {
    private OwnerRepository ownerRepository;
    private VehicleRepository vehicleRepository;

    @EventHandler
    public void on(CreatedVehicleEvent event){
        log.info("************* CreatedVehicleEvent occurred *************");
        Vehicle vehicle = new Vehicle();
        vehicle.setId(UUID.randomUUID().toString());
        vehicle.setBrand(event.getPayload().getBrand());
        vehicle.setHorsepower(event.getPayload().getHorsepower());
        vehicle.setModel(event.getPayload().getModel());
        vehicle.setRegistrationNum(event.getPayload().getRegistrationNum());

        Owner owner = ownerRepository.findByCIN(event.getPayload().getOwnerCIN()).orElse(null);

        if(owner == null){
            owner = new Owner();
            owner.setId(UUID.randomUUID().toString());
            owner.setName(event.getPayload().getOwnerName());
            owner.setCIN(event.getPayload().getOwnerCIN());
            owner.setBirthDate(event.getPayload().getOwnerBirthDate());
            ownerRepository.save(owner);
        }
        vehicle.setOwner(owner);
        vehicleRepository.save(vehicle);
        //owner.getVehicleList().add(vehicle);
    }

    @EventHandler
    public void on(UpdateVehicleOwnerEvent event) throws VehicleNotFoundException, OwnerNotFoundException {
        Vehicle vehicle = vehicleRepository.findByRegistrationNum(event.getId()).orElseThrow(()-> new VehicleNotFoundException(String.format("vehicle %s not found", event.getId())));
        Owner owner = ownerRepository.findByCIN(event.getPayload().getOwnerCIN()).orElseThrow(()-> new OwnerNotFoundException(String.format("owner %s not found", event.getPayload().getOwnerCIN())));
        vehicle.setOwner(owner);
        //owner.getVehicleList().remove(vehicle);
        vehicleRepository.save(vehicle);
    }
}
