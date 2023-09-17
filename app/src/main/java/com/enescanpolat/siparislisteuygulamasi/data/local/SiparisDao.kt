package com.enescanpolat.siparislisteuygulamasi.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.enescanpolat.siparislisteuygulamasi.data.local.entities.SiparisEntity
import com.enescanpolat.siparislisteuygulamasi.data.local.entities.UrunSiparisDataObject
import com.enescanpolat.siparislisteuygulamasi.data.local.entities.UrunSiparisEntity

@Dao
interface SiparisDao {


    @Transaction
    @Query("SELECT * FROM SiparisEntity")
    suspend fun getUrunSiparis():List<UrunSiparisDataObject>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSiparis(siparisEntity: SiparisEntity)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUrunSiparisEntities(urunSiparisEntities: List<UrunSiparisEntity>)


}