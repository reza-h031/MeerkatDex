package ir.companymeerkats.meerkatdex.model.network.web.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WebRequirement (
    @SerializedName("id")
    val id:Long,
    @SerializedName("ram")
    val ram :String,
    @SerializedName("system_version")
    val systemVersion:String,
    @SerializedName("cpu")
    val cpu:String,
    @SerializedName("gpu")
    val gpu:String,
    @SerializedName("storage")
    val storage:String
):Serializable