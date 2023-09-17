package com.enescanpolat.siparislisteuygulamasi.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.enescanpolat.siparislisteuygulamasi.data.local.entities.UrunEntity

@Dao
interface UrunDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUrun(urunEntity: UrunEntity)

    @Query("SELECT * FROM UrunEntity WHERE teslimatcida=:teslimatId")
    suspend fun getTeslimttakiUrunler(teslimatId:String):List<UrunEntity>


}