package com.paul9834.storelist.data.model


import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName


@Parcelize
data class ItemModel(
    @SerialName("id")
    val id: Int? = 0,
    @SerialName("category")
    val category: String? = "",
    @SerialName("description")
    val description: String? = "",
    @SerialName("image")
    val image: String? = "",
    @SerialName("price")
    val price: Double? = 0.0,
    @SerialName("rating")
    val rating: RatingModel? = RatingModel(),
    @SerialName("title")
    val title: String? = ""
)  : Parcelable