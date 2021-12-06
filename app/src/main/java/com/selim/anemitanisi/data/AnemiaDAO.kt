package com.selim.anemitanisi.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.selim.anemitanisi.model.AnemiaResult

@Dao
interface AnemiaDAO {
    @Query("SELECT * FROM anemia_test_results")
    fun getAll(): List<AnemiaResult>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertData(result: AnemiaResult)
}