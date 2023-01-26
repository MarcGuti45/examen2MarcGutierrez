package com.marc.examen2marcgutierrez.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Moble")
data class Moble (

    @ColumnInfo(name = "name")
    var nom: String,

    @ColumnInfo(name = "price")
    var preu: Int
){
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}