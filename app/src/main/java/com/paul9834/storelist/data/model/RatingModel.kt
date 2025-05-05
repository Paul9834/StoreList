package com.paul9834.storelist.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RatingModel(
    @SerialName("count")
    val count: Int? = 0,
    @SerialName("rate")
    val rate: Double? = 0.0
)