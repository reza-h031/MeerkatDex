package ir.companymeerkats.meerkatdex.model.network.web.model.request

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class GameRequest (
    @SerializedName("name")
    val name: String
): Serializable