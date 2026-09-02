package ir.companymeerkats.meerkatdex.model

data class Rating (
    val id:Long,
    val source:String,
    val logoSource:String,
    val rating:String,
    val ratingCount:String
)