package com.enescanpolat.siparislisteuygulamasi.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.enescanpolat.siparislisteuygulamasi.domain.model.Urun

@Entity
data class UrunEntity(
    @PrimaryKey
    val urunId:String,
    val ad:String,
    val adetFiyati:Float,
    val teslimatcida:String
)



