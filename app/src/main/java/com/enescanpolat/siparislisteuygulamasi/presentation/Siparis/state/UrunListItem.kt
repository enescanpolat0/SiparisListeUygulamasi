package com.enescanpolat.siparislisteuygulamasi.presentation.Siparis.state

data class UrunListItem(
    val id:String,
    val ad:String,
    val adetFiyati:Float,
    val secilenMiktar:Int,
    val urunSatildi:Boolean
)
