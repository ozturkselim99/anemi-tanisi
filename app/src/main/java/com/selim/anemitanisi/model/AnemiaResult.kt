package com.selim.anemitanisi.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "anemia_test_results")
data class AnemiaResult(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var rbcValue: Double,
    var hgbValue: Double,
    var hctValue: Double,
    var mcvValue: Double,
    var mchValue: Double,
    var mchcValue: Double,
    var testResult: String,
    var testDate: String,

    )
