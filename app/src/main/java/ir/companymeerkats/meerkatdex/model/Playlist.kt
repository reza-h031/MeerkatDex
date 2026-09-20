package ir.companymeerkats.meerkatdex.model

data class Playlist (
    val id:Long,
    val name:String,
    val description:String,
    val number: Int,
    val games: List<SimpleGame>
){
}