package org.sid.radarservicequeryside.services;

import lombok.AllArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.sid.coreapi.query.GetAllRadarQuery;
import org.sid.radarservicequeryside.entities.Radar;
import org.sid.radarservicequeryside.repositories.RadarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RadarQueryHandler {
    private RadarRepository radarRepository;
    @QueryHandler
    public List<Radar> on(GetAllRadarQuery query){
        return radarRepository.findAll();
    }
}
