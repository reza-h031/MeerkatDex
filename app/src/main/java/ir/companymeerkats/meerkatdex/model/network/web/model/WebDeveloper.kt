package ir.companymeerkats.meerkatdex.mode.web.model


import java.io.Serializable
import com.google.gson.annotations.SerializedName

data class WebDeveloper(
    @SerializedName("id")
    val id :Long,
    @SerializedName("name")
    val name :String,
    @SerializedName("logo")
    val logo :String,
    @SerializedName("website")
    val website :String
):Serializable