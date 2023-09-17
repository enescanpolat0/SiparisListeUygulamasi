package com.enescanpolat.siparislisteuygulamasi.domain.model

import com.enescanpolat.siparislisteuygulamasi.presentation.Siparis.state.UrunListItem

data class SatinAlinanUrun(
    val urunId:String,
    val ad:String,
    val adetFiyati:Float,
    val miktar:Int,

)


