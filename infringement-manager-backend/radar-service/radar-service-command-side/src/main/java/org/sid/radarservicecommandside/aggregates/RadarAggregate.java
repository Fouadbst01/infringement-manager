package org.sid.radarservicecommandside.aggregates;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventhandling.gateway.EventGateway;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.AggregateMember;
import org.axonframework.spring.stereotype.Aggregate;
import org.sid.coreapi.command.CreateRadarCommand;
import org.sid.coreapi.command.DeleteRadarCommand;
import org.sid.coreapi.command.UpdateRadarCommand;
import org.sid.coreapi.events.CreatedRadarEvent;
import org.sid.coreapi.events.DeleteRadarEvent;
import org.sid.coreapi.events.UpdateRadarEvent;

import java.util.ArrayList;
import java.util.List;

@Aggregate
@NoArgsConstructor
@Slf4j
public class RadarAggregate {
    @AggregateIdentifier
    private String radarId;
    private  Float maxSpeed;
    private Double longitude;
    private Double latitude;

    @AggregateMember
    List<OverSpeedMemberAggregate> overSpeedMemberList = new ArrayList<>();
    @CommandHandler
    public RadarAggregate(CreateRadarCommand createRadarCommand){
        log.info("CreateRadarCommand received");
        AggregateLifecycle.apply(new CreatedRadarEvent(
            createRadarCommand.getId(),
            createRadarCommand.getRadarRequestDTO()
        ));
    }

    @CommandHandler
    public void handel(UpdateRadarCommand updateRadarCommand){
        log.info("UpdateRadarCommand received");

        AggregateLifecycle.apply(new UpdateRadarEvent(updateRadarCommand.getId(), updateRadarCommand.getRadarRequestDTO()));
    }
    @CommandHandler
    public void handel(DeleteRadarCommand deleteRadarCommand){
        log.info("DeleteRadarCommand received");

        AggregateLifecycle.apply(new DeleteRadarEvent(deleteRadarCommand.getId()));
    }
    @EventSourcingHandler
    public void on(CreatedRadarEvent event){
        log.info("CreatedRadarEvent occurred");
        this.radarId = event.getId();
        this.maxSpeed = event.getPayload().getMaxSpeed();
        this.latitude=event.getPayload().getLatitude();
        this.longitude=event.getPayload().getLongitude();
    }

    @EventSourcingHandler
    public  void on(UpdateRadarEvent event){
        log.info("UpdateRadarEvent occurred");
        this.maxSpeed = event.getPayload().getMaxSpeed();
        this.latitude=event.getPayload().getLatitude();
        this.longitude=event.getPayload().getLongitude();
    }

    @EventSourcingHandler
    public void on(DeleteRadarEvent deleteRadarEvent){
        AggregateLifecycle.markDeleted();
    }

}
