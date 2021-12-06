package com.selim.anemitanisi.data

import com.selim.anemitanisi.model.AnemiaResult


object MockData {

    private val tempResultList = arrayListOf<AnemiaResult>(
        AnemiaResult(1, 16.00, 14.00, 15.00, 12.00, 13.00, 5.00, "Hasta", "4.12.2021"),
    )

    fun getMockData(): ArrayList<AnemiaResult> {
        return tempResultList
    }

}