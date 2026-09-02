package ir.companymeerkats.meerkatdex.mode.web.model

import com.google.gson.annotations.SerializedName
import ir.companymeerkats.meerkatdex.model.Developer
import ir.companymeerkats.meerkatdex.model.GameImage
import ir.companymeerkats.meerkatdex.model.GameRequirement
import ir.companymeerkats.meerkatdex.model.Genre
import ir.companymeerkats.meerkatdex.model.Platform
import ir.companymeerkats.meerkatdex.model.Publisher
import ir.companymeerkats.meerkatdex.model.Rating
import java.io.Serializable

data class WebGame(
    @SerializedName("id")
    val id:Long,
    @SerializedName("title")
    val title:String,
    @SerializedName("description")
    val description:String,
    @SerializedName("release_date")
    val releaseDate:String,
    @SerializedName("developer")
    val developer: WebDeveloper,
    @SerializedName("publisher")
    val publisher: WebPublisher,
    @SerializedName("website")
    val website:String,
    @SerializedName("status")
    val status:String,
    @SerializedName("platforms")
    val platform: List<WebPlatform>,
    @SerializedName("genres")
    val genre: List <WebGenre>,
    @SerializedName("images")
    val images: List<WebGameImage>,
    @SerializedName("ratings")
    val ratings: List<WebRating>
):Serializable