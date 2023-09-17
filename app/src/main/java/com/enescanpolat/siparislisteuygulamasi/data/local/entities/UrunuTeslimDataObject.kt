package com.enescanpolat.siparislisteuygulamasi.data.local.entities

import androidx.room.Embedded
import androidx.room.Relation

data class UrunuTeslimDataObject(
    @Embedded val teslimatEntity: TeslimatEntity,
    @Relation(
        parentColumn = "teslimatId",
        entityColumn = "teslimatcida"
    )
    val urunler:List<UrunEntity>

)
