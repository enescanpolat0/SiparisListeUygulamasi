package com.enescanpolat.siparislisteuygulamasi.data.dependencyinjection

import android.content.Context
import androidx.room.Room
import com.enescanpolat.siparislisteuygulamasi.data.local.SiparisDao
import com.enescanpolat.siparislisteuygulamasi.data.local.SiparisDatabase
import com.enescanpolat.siparislisteuygulamasi.data.local.TeslimatDao
import com.enescanpolat.siparislisteuygulamasi.data.local.UrunDao
import com.enescanpolat.siparislisteuygulamasi.data.repository.SiparisRepositoryImpl
import com.enescanpolat.siparislisteuygulamasi.data.repository.TeslimatRepositoryImpl
import com.enescanpolat.siparislisteuygulamasi.domain.repository.SiparisRepository
import com.enescanpolat.siparislisteuygulamasi.domain.repository.TeslimatRepository
import com.enescanpolat.siparislisteuygulamasi.domain.use_cases.IsmeGoreFiltrelemeUseCase
import com.enescanpolat.siparislisteuygulamasi.domain.use_cases.IsmeGoreSiralamaUseCase
import com.enescanpolat.siparislisteuygulamasi.domain.use_cases.SiparisiOnaylamaUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object appModule {


    @Singleton
    @Provides
    fun injectSiparisDatabase(@ApplicationContext context:Context):SiparisDatabase{
        return Room.databaseBuilder(
            context,
            SiparisDatabase::class.java,
            "siparis_db"
        )
            .build()
    }


    @Singleton
    @Provides
    fun injectSiparisDao(siparisDatabase: SiparisDatabase):SiparisDao{
        return siparisDatabase.siparisDao()
    }


    @Singleton
    @Provides
    fun injectTeslimatDao(siparisDatabase: SiparisDatabase):TeslimatDao{
        return siparisDatabase.teslimatDao()
    }


    @Singleton
    @Provides
    fun injectUrunDao(siparisDatabase: SiparisDatabase):UrunDao{
        return siparisDatabase.urunDao()
    }

    @Singleton
    @Provides
    fun injectSiparisRepository(siparisDao: SiparisDao,teslimatDao: TeslimatDao,urunDao: UrunDao):SiparisRepository{
        return SiparisRepositoryImpl(siparisDao = siparisDao, teslimatDao = teslimatDao, urunDao = urunDao)
    }


    @Singleton
    @Provides
    fun injectIsmeGoreFiltrelemeUseCase():IsmeGoreFiltrelemeUseCase{
        return IsmeGoreFiltrelemeUseCase()
    }


    @Singleton
    @Provides
    fun injectIsmeGoreSiralamaUseCase():IsmeGoreSiralamaUseCase{
        return IsmeGoreSiralamaUseCase()
    }


    @Singleton
    @Provides
    fun injectTeslimatRepository(teslimatDao: TeslimatDao,urunDao: UrunDao):TeslimatRepository{
        return TeslimatRepositoryImpl(teslimatDao, urunDao)
    }


    @Singleton
    @Provides
    fun injectSiparisiOnylamaUseCase(siparisRepository: SiparisRepository):SiparisiOnaylamaUseCase{
        return SiparisiOnaylamaUseCase(siparisRepository)
    }

}