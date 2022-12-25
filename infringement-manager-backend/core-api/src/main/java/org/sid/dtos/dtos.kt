package org.sid.coreapi.dtos

import java.util.*

data class RadarRequestDTO(
    val maxSpeed : Float=0f,
    val longitude:Double=0.0,
    val latitude:Double=0.0
);

data class RadarResponseDTO(
    var radarId: String="",
    var maxSpeed : Float=0f,
    var longitude:Double=0.0,
    var latitude:Double=0.0
);


data class VehicleRequestDTO(
    val registrationNum:String="",
    val brand:String="",
    val model:String="",
    val horsepower:Int=0,
    val ownerCIN:String="",
    val ownerName:String="",
    val ownerBirthDate: Date= Date()
);

data class VehicleRegistrationResponseDTO(
    var registrationNum:String="",
    var brand:String="",
    var model:String="",
    var horsepower:Int=0,
    var ownerCIN:String="",
    var ownerName:String="",
    var ownerBirthDate: Date= Date()
);


data class OwnerRequestDTO(
    val ownerCIN:String="",
    val ownerName:String="",
    val ownerBirthDate: Date=Date()
);

data class OverSpeedDetectionRequestDTO(
    val registrationNum:String="",
    val radarId:String="",
    val speed:Float=0f,
)


