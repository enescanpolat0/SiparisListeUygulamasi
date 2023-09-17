package com.enescanpolat.siparislisteuygulamasi.presentation.Siparis

import android.annotation.SuppressLint

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enescanpolat.siparislisteuygulamasi.domain.mapper.toSiparisDetayListeItem
import com.enescanpolat.siparislisteuygulamasi.domain.mapper.toSiparisListItem
import com.enescanpolat.siparislisteuygulamasi.domain.model.SatinAlinanUrun
import com.enescanpolat.siparislisteuygulamasi.domain.model.Siparis

import com.enescanpolat.siparislisteuygulamasi.domain.repository.SiparisRepository
import com.enescanpolat.siparislisteuygulamasi.domain.repository.TeslimatRepository
import com.enescanpolat.siparislisteuygulamasi.presentation.Siparis.state.SiparisDetayListeItem
import com.enescanpolat.siparislisteuygulamasi.presentation.Siparis.state.SiparisListItem
import com.enescanpolat.siparislisteuygulamasi.util.FakeData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatter.ofPattern
import javax.inject.Inject




@HiltViewModel
class SiparisViewModel @Inject constructor(
    private val siparisRepository: SiparisRepository,


) :ViewModel() {

    private lateinit var siparisler:List<Siparis>


    var siparisList by mutableStateOf<List<SiparisListItem>>(emptyList())
        private set


    var siparisDiyalogGoster by mutableStateOf(false)
        private set


    var tiklananSiparisItem by mutableStateOf<SiparisDetayListeItem?>(null)
        private set


    init {

        viewModelScope.launch {
            siparisler = siparisRepository.getSiparisler()
            SiparisListesiOlustur()
            /*siparisRepository.insertSiparis(
                Siparis(
                    "1",
                    "15.10.2022 12:05:12",
                    "As fast as possible",
                    "Paper Factory Ltd",
                    listOf(
                        SatinAlinanUrun(
                            "1",
                            "Note book",
                            1.23f,
                            2
                    )
                    )
                )
            )
             */








        }

    }

    fun onSiparisClick(siparisId:String){
        initForSiparisDiyalog(siparisId)
        siparisDiyalogGoster=true
    }

    private fun initForSiparisDiyalog(siparisId:String){
        tiklananSiparisItem = siparisler.firstOrNull{it.siparisId==siparisId}?.toSiparisDetayListeItem()
    }


    fun siparisDiylogKapat(){
        siparisDiyalogGoster=false
        tiklananSiparisItem=null
    }







    @SuppressLint("NewApi")
    private fun SiparisListesiOlustur(){
        val formatter:DateTimeFormatter= ofPattern("dd.MM.yyyy HH:mm:ss")

        siparisList = siparisler.map {siparis ->
            siparis.toSiparisListItem()
        }.sortedByDescending { siparisListItem ->
            LocalDateTime.parse(siparisListItem.siparisTarihi,formatter)
        }
    }







}