package com.enescanpolat.siparislisteuygulamasi.domain.mapper

import com.enescanpolat.siparislisteuygulamasi.data.local.entities.UrunSiparisDataObject
import com.enescanpolat.siparislisteuygulamasi.domain.model.SatinAlinanUrun
import com.enescanpolat.siparislisteuygulamasi.domain.model.Siparis

fun UrunSiparisDataObject.toSiparis(): Siparis {
    return Siparis(
        siparisId = siparisEntity.siparisId,
        tarih = siparisEntity.tarih,
        teslimatTarihi = siparisEntity.teslimatTarihi,
        teslimatciAdi = siparisEntity.teslimatciAdi,
        urunler = urunler.zip(urunSiparisEntities).map {pair ->
            SatinAlinanUrun(
                pair.component1().urunId,
                pair.component1().ad,
                pair.component1().adetFiyati,
                pair.component2().adet
            )
        }
    )
}