package ir.companymeerkats.meerkatdex.model


data class SimpleGame(
    val id: Long,
    val name: String,
    val imageCover: String,
    val imageIcon:String,
    val rating: List<Rating>,
    val genres: List<Genre>,
    val platform: List<SimplePlatform>
)