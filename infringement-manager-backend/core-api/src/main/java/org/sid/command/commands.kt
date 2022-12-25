package org.sid.coreapi.command

import org.axonframework.modelling.command.TargetAggregateIdentifier
import org.sid.coreapi.dtos.OverSpeedDetectionRequestDTO
import org.sid.coreapi.dtos.OwnerRequestDTO
import org.sid.coreapi.dtos.RadarRequestDTO
import org.sid.coreapi.dtos.VehicleRequestDTO

abstract class BaseCommand<T>(
    @TargetAggregateIdentifier
    open val id : T
)

data class CreateRadarCommand (
    override val id : String,
    val radarRequestDTO: RadarRequestDTO
): BaseCommand<String>(id)

data class UpdateRadarCommand (
    override val id : String,
    val radarRequestDTO: RadarRequestDTO
): BaseCommand<String>(id)

data class DeleteRadarCommand(
    override val id: String
): BaseCommand<String>(id)

data class OverSpeedDetectionCommand(
    override val id:String,
    val payload: OverSpeedDetectionRequestDTO
): BaseCommand<String>(id);

data class CreateVehicleCommand(
    override val id:String,
    val payload: VehicleRequestDTO
) : BaseCommand<String>(id);

data class UpdateVehicleOwnerCommand(
    override val id:String,
    val payload: OwnerRequestDTO
): BaseCommand<String>(id);


