package com.enescanpolat.siparislisteuygulamasi.presentation.SiparisUrunSec

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enescanpolat.siparislisteuygulamasi.domain.mapper.toSatinAlinanUrun
import com.enescanpolat.siparislisteuygulamasi.domain.mapper.toUrunListItem
import com.enescanpolat.siparislisteuygulamasi.domain.model.Urun
import com.enescanpolat.siparislisteuygulamasi.domain.repository.SiparisRepository
import com.enescanpolat.siparislisteuygulamasi.domain.use_cases.IsmeGoreFiltrelemeUseCase
import com.enescanpolat.siparislisteuygulamasi.domain.use_cases.IsmeGoreSiralamaUseCase
import com.enescanpolat.siparislisteuygulamasi.domain.use_cases.SiparisiOnaylamaUseCase
import com.enescanpolat.siparislisteuygulamasi.presentation.Siparis.state.UrunListItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel
class SiparisUrunSecViewModel @Inject constructor(

    private val siparisRepository: SiparisRepository,
    private val ismeGoreFiltrelemeUseCase: IsmeGoreFiltrelemeUseCase,
    private val ismeGoreSiralamaUseCase: IsmeGoreSiralamaUseCase,
    private val siparisiOnaylamaUseCase: SiparisiOnaylamaUseCase

) :ViewModel() {

    private lateinit var urunler : List<Urun>

    private lateinit var teslimatciId:String

    var urunleriGoster = mutableStateListOf<UrunListItem>()
        private set

    var secilenUrunler by mutableStateOf<List<UrunListItem>>(emptyList())
        private set

    var urunSearchQuery by mutableStateOf("")
        private set

    var gosterilenDiyalogaGozAt by mutableStateOf(false)
        private set

    fun initUrunList(teslimatciId:String){
        viewModelScope.launch {
            urunler = siparisRepository.getTeslimattakiUrunler(teslimatciId)
            this@SiparisUrunSecViewModel.teslimatciId = teslimatciId
            urunleriOlusturGoster()
        }
    }


    fun onUrunSearchQueryChange(newName:String){
        urunSearchQuery = newName
        urunleriOlusturGoster()
    }



    private fun urunleriOlusturGoster(){
        urunleriGoster =  ismeGoreFiltrelemeUseCase(
            ismeGoreSiralamaUseCase(urunler),urunSearchQuery
        ).map { urun->
            urun.toUrunListItem()
        }.map {urunListItem ->
            val secilenItem = secilenUrunler.firstOrNull {
                it.id == urunListItem.id
            }
            if (secilenItem!=null){
                urunListItem.copy(secilenMiktar = secilenItem.secilenMiktar)
            }else{
                urunListItem
            }
        }.toMutableStateList()
    }


    fun onPlusClick(urunId: String){
        val index = getIndexOfUrunler(urunId)

        if (index<0){
            return
        }

        val mevcutSecilenMiktar = urunleriGoster[index].secilenMiktar


        urunleriGoster[index] = urunleriGoster[index].copy(
            secilenMiktar = mevcutSecilenMiktar +1
        )

        if (mevcutSecilenMiktar == 0){
            secilenUrunler += urunleriGoster[index]
        }else{
            secilenUrunler = secilenUrunler.map {
                if (it.id == urunId){
                    it.copy(secilenMiktar = it.secilenMiktar+1)
                }else{
                    it
                }
            }
        }

    }

    fun onMinusClick(urunId: String){

        val index = getIndexOfUrunler(urunId)

        if (index<0){
            return
        }

        val mevcutSecilenMiktar = urunleriGoster[index].secilenMiktar


        if (mevcutSecilenMiktar==0){
            return
        }

        if (mevcutSecilenMiktar==1){
            secilenUrunler = secilenUrunler.toMutableList().apply {
                removeAll { it.id == urunleriGoster[index].id }
            }
        }

        urunleriGoster[index] = urunleriGoster[index].copy(
            secilenMiktar = mevcutSecilenMiktar -1
        )


    }



    fun onListItemClick(urunId:String){
        val index = getIndexOfUrunler(urunId)
        if (index<0){
            return
        }

        urunleriGoster[index] = urunleriGoster[index].copy(
            urunSatildi = !urunleriGoster[index].urunSatildi
        )


    }


    private fun getIndexOfUrunler(urunId:String):Int{
        return urunleriGoster.indexOfFirst {urunListItem ->
            urunListItem.id==urunId
        }
    }

    fun onCheckOutClick(){
        gosterilenDiyalogaGozAt = true
    }

    fun onDismissChecOutDialog(){
        gosterilenDiyalogaGozAt = false
    }


    fun onSatinAl(){
        siparisiOnaylamaUseCase(
            secilenUrunler.map {
                it.toSatinAlinanUrun()
            },
            teslimatciId = teslimatciId
        )
    }

}