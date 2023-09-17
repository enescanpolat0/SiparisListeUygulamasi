package com.enescanpolat.siparislisteuygulamasi.presentation.SiparisTeslimSec

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enescanpolat.siparislisteuygulamasi.domain.mapper.ToTeslimatciListItem
import com.enescanpolat.siparislisteuygulamasi.domain.mapper.toTeslimatListItem
import com.enescanpolat.siparislisteuygulamasi.domain.model.Teslimat
import com.enescanpolat.siparislisteuygulamasi.domain.repository.SiparisRepository
import com.enescanpolat.siparislisteuygulamasi.domain.use_cases.IsmeGoreFiltrelemeUseCase
import com.enescanpolat.siparislisteuygulamasi.domain.use_cases.IsmeGoreSiralamaUseCase
import com.enescanpolat.siparislisteuygulamasi.presentation.SiparisTeslimSec.state.TeslimatciListItem

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SiparisTeslimSecViewModel @Inject constructor(
    private val siparisRepository: SiparisRepository,
    private val ismeGoreFiltrelemeUseCase: IsmeGoreFiltrelemeUseCase,
    private val ismeGoreSiralamaUseCase: IsmeGoreSiralamaUseCase
) :ViewModel() {


    private lateinit var teslimatcilar : List<Teslimat>

    var teslimatcilariGoster by mutableStateOf<List<TeslimatciListItem>>(emptyList())
        private set

    var teslimatciSearchQuery by mutableStateOf("")
        private set



    init {

        viewModelScope.launch {
            teslimatcilar=siparisRepository.getTeslimatci()

            teslimatciOlusturGoster()
        }
    }


    fun onAramaQueryChange(newValue:String){
        teslimatciSearchQuery = newValue
        teslimatciOlusturGoster()
    }


    private fun teslimatciOlusturGoster(){
        teslimatcilariGoster = ismeGoreFiltrelemeUseCase(
            ismeGoreSiralamaUseCase(teslimatcilar),teslimatciSearchQuery
        ).map {teslimatci->
            teslimatci.ToTeslimatciListItem()
        }
    }


}