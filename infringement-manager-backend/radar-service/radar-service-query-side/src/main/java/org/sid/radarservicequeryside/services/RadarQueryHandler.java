package org.sid.radarservicequeryside.services;

import lombok.AllArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.sid.coreapi.dtos.RadarResponseDTO;
import org.sid.coreapi.query.GetAllRadarQuery;
import org.sid.coreapi.query.GetRadarQuery;
import org.sid.exceptions.RadarNotFoundException;
import org.sid.radarservicequeryside.entities.Radar;
import org.sid.radarservicequeryside.repositories.RadarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RadarQueryHandler {
    private RadarRepository radarRepository;
    @QueryHandler
    public List<Radar> handler(GetAllRadarQuery query){
        return radarRepository.findAll();
    }

    @QueryHandler
    public RadarResponseDTO handler(GetRadarQuery query) throws RadarNotFoundException {
        Radar radar = radarRepository.findById(query.getRadarId()).orElseThrow(()->new RadarNotFoundException(String.format("radar %s not found", query.getRadarId())));
        RadarResponseDTO radarResponseDTO = new RadarResponseDTO();
        radarResponseDTO.setRadarId(radar.getId());
        radarResponseDTO.setMaxSpeed(radar.getMaxSpeed());
        radarResponseDTO.setLatitude(radarResponseDTO.getLatitude());
        radarResponseDTO.setLongitude(radarResponseDTO.getLongitude());
        return radarResponseDTO;
    }
}
