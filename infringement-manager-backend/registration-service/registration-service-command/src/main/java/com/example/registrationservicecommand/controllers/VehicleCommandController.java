package com.example.registrationservicecommand.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.sid.command.CreateVehicleCommand;
import org.sid.dtos.VehicleRequestDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/commands")
@AllArgsConstructor
@Slf4j
public class VehicleCommandController {
    private CommandGateway commandGateway;

    @PostMapping("/vehicles/create")
    public CompletableFuture<String> createNewVehicle(@RequestBody VehicleRequestDTO vehicleRequestDTO){
        return commandGateway.send(
           new CreateVehicleCommand(
               vehicleRequestDTO.getRegistrationNum(),
               vehicleRequestDTO
            )
        );
    }
}
