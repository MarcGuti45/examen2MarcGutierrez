package com.marc.examen2marcgutierrez.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.marc.examen2marcgutierrez.model.Moble


@Database(
    entities = [Moble::class],
    version = 1,
    exportSchema = false
)


abstract class MobleDatabase : RoomDatabase(){
    abstract fun mobleDao() : MobleDao

    companion object{
        @Volatile
        private var INSTANCE: MobleDatabase? = null

        fun getDatabase(context: Context): MobleDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            if (INSTANCE == null) {
                synchronized(this) {
                    // Pass the database to the INSTANCE
                    INSTANCE = buildDatabase(context)
                }
            }
            // Return database.
            return INSTANCE!!
        }

        private fun buildDatabase(context: Context): MobleDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                MobleDatabase::class.java,
                "moble_database"
            )
                .build()
        }
    }
}