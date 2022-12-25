package org.sid.coreapi.dtos

import java.util.*

data class RadarRequestDTO(
    var maxSpeed : Float=0f,
    var longitude:Double=0.0,
    var latitude:Double=0.0
);


data class VehicleRequestDTO(
    val registrationNum:String,
    val brand:String,
    val model:String,
    val horsepower:Int,
    val ownerId:String,
    val ownerName:String,
    val ownerBirthDate: Date
);


