package org.sid.coreapi.events

import org.sid.coreapi.dtos.RadarRequestDTO

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
