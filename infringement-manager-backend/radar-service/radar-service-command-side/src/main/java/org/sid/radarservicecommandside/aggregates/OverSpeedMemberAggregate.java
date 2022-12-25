package org.sid.radarservicecommandside.aggregates;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.modelling.command.EntityId;

@Data @AllArgsConstructor @NoArgsConstructor
@Slf4j
public class OverSpeedMemberAggregate {
    @EntityId
    private String OverSpeedMemberId;
    private String vehicleRegistrationNumber;
    private float vehicleSpeed;
}
