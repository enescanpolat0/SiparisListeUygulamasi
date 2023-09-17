package com.enescanpolat.siparislisteuygulamasi.domain.mapper

import com.enescanpolat.siparislisteuygulamasi.domain.model.SatinAlinanUrun
import com.enescanpolat.siparislisteuygulamasi.presentation.Siparis.state.UrunListItem

fun SatinAlinanUrun.toUrunListItem(): UrunListItem {
    return UrunListItem(urunId,ad,adetFiyati,miktar,urunSatildi = false)
}