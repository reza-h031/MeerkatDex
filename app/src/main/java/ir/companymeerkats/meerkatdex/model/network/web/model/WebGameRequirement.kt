package ir.companymeerkats.meerkatdex.mode.web.model

import com.google.gson.annotations.SerializedName
import ir.companymeerkats.meerkatdex.model.Requirement
import ir.companymeerkats.meerkatdex.model.network.web.model.WebRequirement
import java.io.Serializable

data class WebGameRequirement (
    @SerializedName("id")
    val id :Long,
    @SerializedName("minimum")
    val minimumRequirements: WebRequirement,
    @SerializedName("recommended")
    val recommendedRequirements: WebRequirement
):Serializable