package org.sid.radarservicequeryside.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.sid.coreapi.dtos.RadarResponseDTO;
import org.sid.coreapi.query.GetAllRadarQuery;
import org.sid.coreapi.query.GetRadarQuery;
import org.sid.radarservicequeryside.entities.Radar;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/query")
public class RadarQueryController {
    private QueryGateway queryGateway;

    @GetMapping("/radars")
    public CompletableFuture<List<Radar>> getListRadars(){
        return queryGateway.query(new GetAllRadarQuery(), ResponseTypes.multipleInstancesOf(Radar.class));
    }

    @GetMapping("/radar/{radarId}")
    public CompletableFuture<RadarResponseDTO> getRadar(@PathVariable String radarId){
        return queryGateway.query(new GetRadarQuery(radarId), ResponseTypes.instanceOf(RadarResponseDTO.class));
    }
}
