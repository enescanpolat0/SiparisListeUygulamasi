package com.enescanpolat.siparislisteuygulamasi.data.local.entities

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.enescanpolat.siparislisteuygulamasi.domain.model.SatinAlinanUrun
import com.enescanpolat.siparislisteuygulamasi.domain.model.Siparis

data class UrunSiparisDataObject(
    @Embedded val siparisEntity: SiparisEntity,
    @Relation(
        parentColumn = "siparisId",
        entityColumn = "urunId",
        associateBy = Junction(UrunSiparisEntity::class)
    )
    val urunler:List<UrunEntity>,
    @Relation(
        parentColumn = "siparisId",
        entityColumn = "siparisId"
    )
    val urunSiparisEntities: List<UrunSiparisEntity>
)



