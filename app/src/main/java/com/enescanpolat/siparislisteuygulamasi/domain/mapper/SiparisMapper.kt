package com.enescanpolat.siparislisteuygulamasi.domain.mapper

import com.enescanpolat.siparislisteuygulamasi.data.local.entities.SiparisEntity
import com.enescanpolat.siparislisteuygulamasi.domain.model.Siparis
import com.enescanpolat.siparislisteuygulamasi.presentation.Siparis.state.SiparisDetayListeItem
import com.enescanpolat.siparislisteuygulamasi.presentation.Siparis.state.SiparisListItem

fun Siparis.toSiparisDetayListeItem(): SiparisDetayListeItem {
    return SiparisDetayListeItem(siparisId,teslimatciAdi,tarih,urunler.map {satinAlinanUrun ->
        satinAlinanUrun.toUrunListItem()
    }
    )
}


fun Siparis.toSiparisListItem(): SiparisListItem {
    return SiparisListItem(siparisId,teslimatciAdi, siparisTarihi = tarih , toplamTutar = urunler.sumOf { (it.adetFiyati*it.miktar).toDouble() })
}

fun Siparis.toSiparisEntity(teslimatciAdi: String): SiparisEntity {
    return SiparisEntity(siparisId, tarih, teslimatTarihi, teslimatciAdi)
}