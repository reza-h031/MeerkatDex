package ir.companymeerkats.meerkatdex.model.network.web.model

import com.google.gson.annotations.SerializedName
import ir.companymeerkats.meerkatdex.mode.web.model.WebGenre
import ir.companymeerkats.meerkatdex.mode.web.model.WebPlatform
import ir.companymeerkats.meerkatdex.mode.web.model.WebRating
import ir.companymeerkats.meerkatdex.model.Platform

data class WebSimpleGame (
    @SerializedName("id")
    val id: Long,
    @SerializedName("title")
    val name: String,
    @SerializedName("image_cover")
    val imageCover: Int,
    @SerializedName("image_icon")
    val imageIcon:Int,
    @SerializedName("ratings")
    val rating: List<WebRating>,
    @SerializedName("genres")
    val genres: List<WebGenre>,
    @SerializedName("platforms")
    val platform: List<WebPlatform>
)