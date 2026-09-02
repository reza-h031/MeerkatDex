package ir.companymeerkats.meerkatdex.mode.web.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WebPublisher (
    @SerializedName("id")
    val id :Long,
    @SerializedName("name")
    val name :String,
    @SerializedName("logo")
    val logo :String,
    @SerializedName("website")
    val website :String
):Serializable