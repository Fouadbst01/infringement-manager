package org.sid.radarservicequeryside.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.sid.coreapi.query.GetAllRadarQuery;
import org.sid.radarservicequeryside.entities.Radar;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/radar/query")
public class RadarQueryController {
    private QueryGateway queryGateway;
    public CompletableFuture<List<Radar>> radar(){
        return queryGateway.query(new GetAllRadarQuery(), ResponseTypes.multipleInstancesOf(Radar.class));
    }
}
