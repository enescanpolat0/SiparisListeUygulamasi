package com.enescanpolat.siparislisteuygulamasi.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class SiparisEntity(
    @PrimaryKey val siparisId:String,
    val tarih:String,
    val teslimatTarihi:String,
    val teslimatciAdi:String,

)
