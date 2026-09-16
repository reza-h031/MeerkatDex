package ir.companymeerkats.meerkatdex.model

data class Playlist (
    val id:Long,
    val name:String,
    val games: List<SimpleGame>
){
}