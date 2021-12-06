package com.selim.anemitanisi.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.selim.anemitanisi.model.AnemiaResult

@Database(entities = [AnemiaResult::class], version = 1)
abstract class AnemiaDatabase : RoomDatabase() {
    abstract fun anemiaDao(): AnemiaDAO

    companion object {
        private var INSTANCE: AnemiaDatabase? = null
        fun getDatabase(context: Context): AnemiaDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            val instance = Room.databaseBuilder(
                context.applicationContext,
                AnemiaDatabase::class.java,
                "anemia_result_db"
            ).allowMainThreadQueries().build()
            INSTANCE = instance
            return instance
        }
    }


}