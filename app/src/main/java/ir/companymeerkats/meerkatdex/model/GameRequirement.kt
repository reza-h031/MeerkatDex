package ir.companymeerkats.meerkatdex.model

data class GameRequirement (
    val id :Long ,
    val minimumRequirements:Requirement,
    val recommendedRequirements:Requirement
)