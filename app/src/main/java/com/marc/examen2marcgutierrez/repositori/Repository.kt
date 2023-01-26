package com.marc.examen2marcgutierrez.repositori

import android.content.Context
import androidx.lifecycle.LiveData
import com.marc.examen2marcgutierrez.databases.MobleDatabase
import com.marc.examen2marcgutierrez.model.Moble
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Repository {
    companion object {

        var mobleDatabase: MobleDatabase? = null

        var moble: LiveData<List<Moble>>? = null

        fun initializeDB(context: Context): MobleDatabase {
            return MobleDatabase.getDatabase(context)
        }

        //TODO: INSERT MOBLES
        fun insertMobles(context: Context, moble: Moble) {

            mobleDatabase = initializeDB(context)

            CoroutineScope(Dispatchers.IO).launch {
                mobleDatabase!!.mobleDao().addMoble(moble)
            }
        }

        //TODO: SELECT MOBLES
        fun getMobles(context: Context): LiveData<List<Moble>>? {

            mobleDatabase = initializeDB(context)

            moble = mobleDatabase!!.mobleDao().getMobles()

            return moble
        }

    }
}