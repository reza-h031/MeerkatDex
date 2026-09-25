package ir.companymeerkats.meerkatdex.model


data class SimpleGame(
    val id: Long,
    val name: String,
    val imageCover: Int,
    val imageIcon:Int,
    val rating: List<Rating>,
    val genres: List<Genre>,
    val platform: List<Platform>
)