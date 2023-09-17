package com.enescanpolat.siparislisteuygulamasi.domain.mapper

import com.enescanpolat.siparislisteuygulamasi.data.local.entities.UrunEntity
import com.enescanpolat.siparislisteuygulamasi.domain.model.SatinAlinanUrun
import com.enescanpolat.siparislisteuygulamasi.domain.model.Urun
import com.enescanpolat.siparislisteuygulamasi.presentation.Siparis.state.UrunListItem

fun UrunEntity.toUrun(): Urun {
    return Urun(urunId, ad, adetFiyati)
}

fun Urun.toUrunEntity(teslimatciId:String):UrunEntity{
    return UrunEntity(urunId,ad,adetFiyati,teslimatciId)
}

fun Urun.toUrunListItem():UrunListItem{
    return UrunListItem(urunId,ad,adetFiyati,0,false)
}

fun UrunListItem.toSatinAlinanUrun():SatinAlinanUrun{
    return SatinAlinanUrun(

        urunId = id,
        ad = ad,
        adetFiyati = adetFiyati,
        miktar = secilenMiktar
    )
}