package com.enescanpolat.siparislisteuygulamasi.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.enescanpolat.siparislisteuygulamasi.data.local.entities.SiparisEntity
import com.enescanpolat.siparislisteuygulamasi.data.local.entities.TeslimatEntity
import com.enescanpolat.siparislisteuygulamasi.data.local.entities.UrunEntity
import com.enescanpolat.siparislisteuygulamasi.data.local.entities.UrunSiparisEntity


@Database(
    entities = [TeslimatEntity::class,SiparisEntity::class,UrunSiparisEntity::class,UrunEntity::class],
    version = 1
)
abstract class SiparisDatabase:RoomDatabase() {

    abstract fun siparisDao():SiparisDao
    abstract fun urunDao():UrunDao
    abstract fun teslimatDao():TeslimatDao


}