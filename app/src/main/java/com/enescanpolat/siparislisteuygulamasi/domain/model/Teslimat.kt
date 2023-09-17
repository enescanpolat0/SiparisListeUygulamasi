package com.enescanpolat.siparislisteuygulamasi.domain.model

import com.enescanpolat.siparislisteuygulamasi.domain.IsmeGoreSecVeSirala
import com.enescanpolat.siparislisteuygulamasi.presentation.Siparis.state.TeslimatListItem

data class Teslimat(
    val teslimatId:String,
    override val ad:String,
    val urunler:List<Urun>
):IsmeGoreSecVeSirala


