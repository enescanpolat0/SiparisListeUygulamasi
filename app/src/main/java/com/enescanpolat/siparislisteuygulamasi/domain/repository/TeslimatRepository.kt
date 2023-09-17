package com.enescanpolat.siparislisteuygulamasi.domain.repository

import com.enescanpolat.siparislisteuygulamasi.domain.model.Teslimat
import com.enescanpolat.siparislisteuygulamasi.domain.model.Urun

interface TeslimatRepository {

    suspend fun insertTeslimatcilar(list: List<Teslimat>)

    suspend fun insertUrunler(list: List<Urun>, teslimatciId:String)
}