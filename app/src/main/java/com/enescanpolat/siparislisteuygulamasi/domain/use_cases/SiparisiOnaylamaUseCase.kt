package com.enescanpolat.siparislisteuygulamasi.domain.use_cases

import android.os.Build
import androidx.annotation.RequiresApi
import com.enescanpolat.siparislisteuygulamasi.domain.model.SatinAlinanUrun
import com.enescanpolat.siparislisteuygulamasi.domain.model.Siparis
import com.enescanpolat.siparislisteuygulamasi.domain.repository.SiparisRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.UUID
import javax.inject.Inject

class SiparisiOnaylamaUseCase @Inject constructor(
    private val siparisRepository: SiparisRepository
) {


    @RequiresApi(Build.VERSION_CODES.O)
    operator fun invoke(urunler:List<SatinAlinanUrun>, teslimatciId:String){
        val coroutineScope = CoroutineScope(Dispatchers.IO)
        val formatter :DateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")
        val tarih = formatter.format(LocalDateTime.now())

        coroutineScope.launch {
            val teslimatciAdi = siparisRepository.getTeslimatciAdiById(teslimatciId)

            siparisRepository.insertSiparis(
                siparis = Siparis(
                    siparisId = UUID.randomUUID().toString(),
                    tarih = tarih,
                    teslimatTarihi = "En kisa zamanda",
                    teslimatciAdi = teslimatciAdi,
                    urunler = urunler
                )
            )
        }


    }

}