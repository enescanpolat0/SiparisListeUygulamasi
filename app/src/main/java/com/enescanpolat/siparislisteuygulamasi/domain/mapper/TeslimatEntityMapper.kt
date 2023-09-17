package com.enescanpolat.siparislisteuygulamasi.domain.mapper

import com.enescanpolat.siparislisteuygulamasi.data.local.entities.TeslimatEntity
import com.enescanpolat.siparislisteuygulamasi.domain.model.Teslimat
import com.enescanpolat.siparislisteuygulamasi.domain.model.Urun

fun TeslimatEntity.toTeslimat(urunler:List<Urun>): Teslimat {
    return Teslimat(teslimatId,ad,urunler)
}