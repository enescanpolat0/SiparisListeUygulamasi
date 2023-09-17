package com.enescanpolat.siparislisteuygulamasi.presentation.Siparis.state

import com.enescanpolat.siparislisteuygulamasi.domain.model.Urun

data class SiparisDetayListeItem(
    val siparisId:String,
    val teslimatciadi:String,
    val siparisTarihi:String,
    val urunler:List<UrunListItem>
)
