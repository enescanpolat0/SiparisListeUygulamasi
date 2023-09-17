package com.enescanpolat.siparislisteuygulamasi.domain.model

import com.enescanpolat.siparislisteuygulamasi.domain.IsmeGoreSecVeSirala

data class Urun(
    val urunId:String,
    override val ad:String,
    val adetFiyati:Float
):IsmeGoreSecVeSirala




