package com.enescanpolat.siparislisteuygulamasi.domain.model

import com.enescanpolat.siparislisteuygulamasi.data.local.entities.SiparisEntity
import com.enescanpolat.siparislisteuygulamasi.presentation.Siparis.state.SiparisDetayListeItem
import com.enescanpolat.siparislisteuygulamasi.presentation.Siparis.state.SiparisListItem

data class Siparis(
    val siparisId:String,
    val tarih:String,
    val teslimatTarihi:String,
    val teslimatciAdi:String,
    val urunler:List<SatinAlinanUrun>
)





