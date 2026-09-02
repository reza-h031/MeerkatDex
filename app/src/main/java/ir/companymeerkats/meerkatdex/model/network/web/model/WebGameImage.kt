package ir.companymeerkats.meerkatdex.mode.web.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class WebGameImage (
    @SerializedName("id")
    val id :Long,
    @SerializedName("path")
    val path:String,
    @SerializedName("type")
    val type:String
):Serializable