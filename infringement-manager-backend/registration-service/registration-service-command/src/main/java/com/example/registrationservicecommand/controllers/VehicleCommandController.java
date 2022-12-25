package com.example.registrationservicecommand.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.sid.coreapi.command.CreateVehicleCommand;
import org.sid.coreapi.command.UpdateVehicleOwnerCommand;
import org.sid.coreapi.dtos.OwnerRequestDTO;
import org.sid.coreapi.dtos.VehicleRequestDTO;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/vehicles/updateOwner/{idVehicle}")
    public CompletableFuture<String> UpdateVehicleOwner(@PathVariable String idVehicle,@RequestBody OwnerRequestDTO ownerRequestDTO){
        return commandGateway.send(
            new UpdateVehicleOwnerCommand(
                idVehicle,
                ownerRequestDTO
            )
        );
    }

}
