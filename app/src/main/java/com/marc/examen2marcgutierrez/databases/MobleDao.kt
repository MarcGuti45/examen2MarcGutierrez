package com.marc.examen2marcgutierrez.databases

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.marc.examen2marcgutierrez.model.Moble

@Dao
interface MobleDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addMoble(moble: Moble)

    @Query("SELECT * FROM Moble")
    fun getMobles(): LiveData<List<Moble>>

/*
    @Query("DELETE FROM Moble WHERE name =: editTextNomDetail")
    fun deleteMoble(marca:String): LiveData<List<Moble>>

    @Query("UPDATE Moble SET WHERE")
    fun updateMoble(): LiveData<List<Moble>>

 */
}