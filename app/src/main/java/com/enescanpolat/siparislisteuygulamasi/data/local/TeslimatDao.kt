package com.enescanpolat.siparislisteuygulamasi.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.enescanpolat.siparislisteuygulamasi.data.local.entities.TeslimatEntity
import com.enescanpolat.siparislisteuygulamasi.data.local.entities.UrunuTeslimDataObject

@Dao
interface TeslimatDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeslimat(teslimatEntity: TeslimatEntity)

    @Transaction
    @Query("SELECT * FROM TeslimatEntity")
    suspend fun getTeslimatlar():List<UrunuTeslimDataObject>


    @Query("SELECT ad FROM teslimatentity WHERE teslimatId =:teslimatId")
    suspend fun getTeslimatAdibyId(teslimatId:String):String



}