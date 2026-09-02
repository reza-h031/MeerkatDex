package ir.companymeerkats.meerkatdex.model

data class Requirement (
    val id:Long,
    val ram :String,
    val systemVersion:String,
    val cpu:String,
    val gpu:String,
    val storage:String
)