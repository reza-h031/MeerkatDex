package ir.companymeerkats.meerkatdex.mode.web.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WebRating(
    @SerializedName("id")
    val id:Long,
    @SerializedName("source")
    val source:String,
    @SerializedName("logoSource")
    val logoSource:String,
    @SerializedName("rating")
    val rating:String,
    @SerializedName("ratingCount")
    val ratingCount:String
):Serializable