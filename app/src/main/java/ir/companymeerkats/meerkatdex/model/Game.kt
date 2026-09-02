package ir.companymeerkats.meerkatdex.model

data class Game (
    val id:Long,
    val title:String,
    val description:String,
    val releaseDate:String,
    val developer: Developer,
    val publisher: Publisher,
    val website:String,
    val status:String,
    val platform:List<Platform>,
    val genre: List<Genre>,
    val images: List<GameImage>,
    val ratings:List<Rating>
)