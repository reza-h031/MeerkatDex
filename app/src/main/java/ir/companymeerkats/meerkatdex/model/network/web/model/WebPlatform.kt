package ir.companymeerkats.meerkatdex.mode.web.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WebPlatform (
    @SerializedName("id")
    val id :Long,
    @SerializedName("name")
    val name :String,
    @SerializedName("logo")
    val logo :String?,
    @SerializedName("version")
    val version:String?,
    @SerializedName("releaseDate")
    val releaseDate:String?,
    @SerializedName("downloadSize")
    val downloadSize:String?,
    @SerializedName("requirement")
    val requirement: WebGameRequirement?
):Serializable