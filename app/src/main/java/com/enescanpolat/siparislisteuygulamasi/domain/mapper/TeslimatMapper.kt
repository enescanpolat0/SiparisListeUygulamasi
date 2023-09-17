package com.enescanpolat.siparislisteuygulamasi.domain.mapper

import com.enescanpolat.siparislisteuygulamasi.data.local.entities.TeslimatEntity
import com.enescanpolat.siparislisteuygulamasi.domain.model.Teslimat
import com.enescanpolat.siparislisteuygulamasi.presentation.Siparis.state.TeslimatListItem
import com.enescanpolat.siparislisteuygulamasi.presentation.SiparisTeslimSec.state.TeslimatciListItem

fun Teslimat.toTeslimatListItem(): TeslimatListItem {
    return TeslimatListItem(teslimatId,ad)
}

fun Teslimat.ToTeslimatciListItem():TeslimatciListItem{
    return TeslimatciListItem(teslimatId,ad)
}

fun Teslimat.toTeslimatciEntity():TeslimatEntity{
    return TeslimatEntity(teslimatId, ad)
}