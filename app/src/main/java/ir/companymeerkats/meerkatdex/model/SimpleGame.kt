package ir.companymeerkats.meerkatdex.model


data class SimpleGame(
    val id: Long,
    val name: String,
    val imageCover: Int,
    val imageIcon:Int,
    val rating: Double,
    val genres: List<String>
)