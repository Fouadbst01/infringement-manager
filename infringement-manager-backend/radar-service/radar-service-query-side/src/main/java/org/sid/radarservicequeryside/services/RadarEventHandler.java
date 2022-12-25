package org.sid.radarservicequeryside.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.sid.coreapi.events.CreatedRadarEvent;
import org.sid.coreapi.events.DeleteRadarEvent;
import org.sid.coreapi.events.UpdateRadarEvent;
import org.sid.coreapi.query.GetAllRadarQuery;
import org.sid.exceptions.RadarNotFoundException;
import org.sid.radarservicequeryside.entities.Radar;
import org.sid.radarservicequeryside.repositories.RadarRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class RadarEventHandler {
    private RadarRepository radarRepository;
    @EventHandler
    public void on(CreatedRadarEvent event){
        Radar radar = new Radar();
        radar.setId(event.getId());
        radar.setMaxSpeed(event.getPayload().getMaxSpeed());
        radar.setLatitude(event.getPayload().getLatitude());
        radar.setLongitude(event.getPayload().getLongitude());
        radarRepository.save(radar);
    }

    @EventHandler
    public void on(UpdateRadarEvent event) throws RadarNotFoundException {
        Radar radar = radarRepository.findById(event.getId()).orElseThrow(()->new RadarNotFoundException(String.format("radar not %s found", event.getId())));
        radar.setMaxSpeed(event.getPayload().getMaxSpeed());
        radar.setLatitude(event.getPayload().getLatitude());
        radar.setLongitude(event.getPayload().getLongitude());
        radarRepository.save(radar);
    }

    @EventHandler
    public void on(DeleteRadarEvent event) throws RadarNotFoundException {
        Radar radar = radarRepository.findById(event.getId()).orElseThrow(()->new RadarNotFoundException(String.format("radar not %s found", event.getId())));
        radarRepository.delete(radar);
    }
}
