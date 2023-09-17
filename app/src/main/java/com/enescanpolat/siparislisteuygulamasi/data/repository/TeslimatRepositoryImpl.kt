package com.enescanpolat.siparislisteuygulamasi.data.repository

import com.enescanpolat.siparislisteuygulamasi.data.local.TeslimatDao
import com.enescanpolat.siparislisteuygulamasi.data.local.UrunDao

import com.enescanpolat.siparislisteuygulamasi.domain.mapper.toTeslimatciEntity
import com.enescanpolat.siparislisteuygulamasi.domain.mapper.toUrunEntity
import com.enescanpolat.siparislisteuygulamasi.domain.model.Teslimat
import com.enescanpolat.siparislisteuygulamasi.domain.model.Urun
import com.enescanpolat.siparislisteuygulamasi.domain.repository.TeslimatRepository
import javax.inject.Inject

class TeslimatRepositoryImpl @Inject constructor(
    private val teslimatDao: TeslimatDao,
    private val urunDao: UrunDao
) :TeslimatRepository {
    override suspend fun insertTeslimatcilar(list: List<Teslimat>) {
        list.forEach{teslimatci->
            teslimatDao.insertTeslimat(teslimatci.toTeslimatciEntity())
            insertUrunler(teslimatci.urunler,teslimatci.teslimatId)
        }
    }

    override suspend fun insertUrunler(list: List<Urun>, teslimatciId: String) {
        list.forEach{urun->
            urunDao.insertUrun(urun.toUrunEntity(teslimatciId))
        }
    }
}