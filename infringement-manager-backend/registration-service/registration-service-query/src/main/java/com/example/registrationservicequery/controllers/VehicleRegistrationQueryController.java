package com.example.registrationservicequery.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.sid.coreapi.dtos.VehicleRegistrationResponseDTO;
import org.sid.coreapi.query.getVehicleRegistrationQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/query")
public class VehicleRegistrationQueryController {
    private QueryGateway queryGateway;

    @GetMapping("/registration/{matriculation}")
    public CompletableFuture<VehicleRegistrationResponseDTO> getVehicleRegistration(@PathVariable String matriculation){
        return  queryGateway.query(new getVehicleRegistrationQuery(matriculation), ResponseTypes.instanceOf(VehicleRegistrationResponseDTO.class));
    }
}
