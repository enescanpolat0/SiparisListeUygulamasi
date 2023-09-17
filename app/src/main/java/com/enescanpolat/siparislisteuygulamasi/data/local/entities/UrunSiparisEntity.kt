package com.enescanpolat.siparislisteuygulamasi.data.local.entities

import androidx.room.Entity

@Entity(primaryKeys = ["siparisId","urunId"])
data class UrunSiparisEntity(
    val siparisId:String,
    val urunId:String,
    val adet:Int
)