package ir.companymeerkats.meerkatdex.model.network.web.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WebSimplePlatform(
    @SerializedName("id")
    val id :Long,
    @SerializedName("name")
    val name :String,
    @SerializedName("logo")
    val logo :String?
): Serializable