package ir.companymeerkats.meerkatdex.mode.web.model

import com.google.gson.annotations.SerializedName
import ir.companymeerkats.meerkatdex.model.SimpleGame
import ir.companymeerkats.meerkatdex.model.network.web.model.WebSimpleGame

data class WebPlaylist(
    @SerializedName("id")
    val id:Long,
    @SerializedName("name")
    val name:String,
    @SerializedName("description")
    val description:String,
    @SerializedName("number")
    val number: Int,
    @SerializedName("games")
    val games: List<WebSimpleGame>
): java.io.Serializable