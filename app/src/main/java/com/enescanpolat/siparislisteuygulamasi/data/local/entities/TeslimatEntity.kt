package com.enescanpolat.siparislisteuygulamasi.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.enescanpolat.siparislisteuygulamasi.domain.model.Teslimat
import com.enescanpolat.siparislisteuygulamasi.domain.model.Urun


@Entity
data class TeslimatEntity(
    @PrimaryKey
    val teslimatId:String,
    val ad:String
)


