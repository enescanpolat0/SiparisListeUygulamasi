package com.enescanpolat.siparislisteuygulamasi.data.repository

import com.enescanpolat.siparislisteuygulamasi.data.local.SiparisDao
import com.enescanpolat.siparislisteuygulamasi.data.local.TeslimatDao
import com.enescanpolat.siparislisteuygulamasi.data.local.UrunDao
import com.enescanpolat.siparislisteuygulamasi.data.local.entities.UrunSiparisEntity

import com.enescanpolat.siparislisteuygulamasi.domain.mapper.toSiparis
import com.enescanpolat.siparislisteuygulamasi.domain.mapper.toSiparisEntity
import com.enescanpolat.siparislisteuygulamasi.domain.mapper.toTeslimat
import com.enescanpolat.siparislisteuygulamasi.domain.mapper.toUrun
import com.enescanpolat.siparislisteuygulamasi.domain.model.Siparis
import com.enescanpolat.siparislisteuygulamasi.domain.model.Teslimat
import com.enescanpolat.siparislisteuygulamasi.domain.model.Urun

import com.enescanpolat.siparislisteuygulamasi.domain.repository.SiparisRepository
import javax.inject.Inject

class SiparisRepositoryImpl @Inject constructor(
    private val siparisDao: SiparisDao,
    private val teslimatDao: TeslimatDao,
    private val urunDao: UrunDao
):SiparisRepository {
    override suspend fun insertSiparis(siparis: Siparis) {
        siparisDao.insertSiparis(siparis.toSiparisEntity(siparis.teslimatciAdi))
        val urunSiparisEntities = siparis.urunler.map { satinAlinanUrun ->
            UrunSiparisEntity(siparis.siparisId,satinAlinanUrun.urunId,satinAlinanUrun.miktar)
        }
        siparisDao.insertUrunSiparisEntities(urunSiparisEntities)
    }

    override suspend fun getSiparisler(): List<Siparis> {
        return siparisDao.getUrunSiparis().map {
            it.toSiparis()
        }
    }

    override suspend fun getTeslimatci(): List<Teslimat> {
        return teslimatDao.getTeslimatlar().map {
            it.teslimatEntity.toTeslimat(
                it.urunler.map {urunEntity ->
                    urunEntity.toUrun()
                }
            )
        }
    }

    override suspend fun getTeslimattakiUrunler(teslimatciId: String): List<Urun> {
        return urunDao.getTeslimttakiUrunler(teslimatciId).map {urunEntity ->
            urunEntity.toUrun()
        }
    }

    override suspend fun getTeslimatciAdiById(teslimatciId: String): String {
        return teslimatDao.getTeslimatAdibyId(teslimatciId)
    }
}