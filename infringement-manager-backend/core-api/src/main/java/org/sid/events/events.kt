package org.sid.coreapi.events

import org.sid.coreapi.dtos.OwnerRequestDTO
import org.sid.coreapi.dtos.RadarRequestDTO
import org.sid.coreapi.dtos.VehicleRequestDTO

abstract class BaseEvent<T>(
    open val id : T
);

data class CreatedRadarEvent(
    override val id : String,
    val payload: RadarRequestDTO
): BaseEvent<String>(id);

data class UpdateRadarEvent(
    override val id : String,
    val payload: RadarRequestDTO
): BaseEvent<String>(id);

data class DeleteRadarEvent(
    override val id : String,
): BaseEvent<String>(id);

data class CreatedVehicleEvent(
    override val id : String,
    val payload: VehicleRequestDTO
): BaseEvent<String>(id);

data class  UpdateVehicleOwnerEvent(
    override val id : String,
    val payload: OwnerRequestDTO
): BaseEvent<String>(id);

