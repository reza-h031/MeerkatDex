package ir.companymeerkats.meerkatdex.model


data class Platform (
    val id :Long,
    val name :String,
    val logo :String,
    val version:String,
    val releaseDate:String,
    val downloadSize:String,
    val gameRequirement: GameRequirement
    )