package org.sid.radarservicecommandside.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.sid.coreapi.command.CreateRadarCommand;
import org.sid.coreapi.command.DeleteRadarCommand;
import org.sid.coreapi.command.OverSpeedDetectionCommand;
import org.sid.coreapi.command.UpdateRadarCommand;
import org.sid.coreapi.dtos.OverSpeedDetectionRequestDTO;
import org.sid.coreapi.dtos.RadarRequestDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/command")
@Slf4j
@AllArgsConstructor
public class RadarCommandController {
    private CommandGateway commandGateway;

    @PostMapping("/radar/create")
    public CompletableFuture<String> creatRadar(@RequestBody RadarRequestDTO radarRequestDTO){
        return commandGateway.send(new CreateRadarCommand(UUID.randomUUID().toString(),radarRequestDTO));
    }

    @PutMapping("/radar/update/{radarId}")
    public CompletableFuture<String> updateRadar(@PathVariable String radarId,@RequestBody RadarRequestDTO radarRequestDTO){
        return commandGateway.send(new UpdateRadarCommand(radarId,radarRequestDTO));
    }

    @DeleteMapping("/radar/delete/{radarId}")
    public CompletableFuture<String> deleteRadar(@PathVariable String radarId){
        return commandGateway.send(new DeleteRadarCommand(radarId));
    }

    @PutMapping("/radar/overSpeed")
    public CompletableFuture<String> deleteRadar(@PathVariable OverSpeedDetectionRequestDTO overSpeedDetctoinRequestDTO){
        return commandGateway.send(new OverSpeedDetectionCommand(overSpeedDetctoinRequestDTO.getRegistrationNum(),overSpeedDetctoinRequestDTO));
    }

}
