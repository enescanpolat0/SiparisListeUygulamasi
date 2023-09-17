package com.enescanpolat.siparislisteuygulamasi.domain.repository

import com.enescanpolat.siparislisteuygulamasi.domain.model.Siparis
import com.enescanpolat.siparislisteuygulamasi.domain.model.Teslimat
import com.enescanpolat.siparislisteuygulamasi.domain.model.Urun

interface SiparisRepository {


    suspend fun insertSiparis(siparis: Siparis)

    suspend fun getSiparisler():List<Siparis>

    suspend fun getTeslimatci():List<Teslimat>

    suspend fun getTeslimattakiUrunler(teslimatciId:String):List<Urun>

    suspend fun getTeslimatciAdiById(teslimatciId: String):String


}