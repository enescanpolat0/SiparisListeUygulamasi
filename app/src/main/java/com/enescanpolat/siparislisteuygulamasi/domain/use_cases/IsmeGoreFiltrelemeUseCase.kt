package com.enescanpolat.siparislisteuygulamasi.domain.use_cases

import com.enescanpolat.siparislisteuygulamasi.domain.IsmeGoreSecVeSirala

class IsmeGoreFiltrelemeUseCase {


    operator fun <T>invoke(list: List<T>,ad:String):List<T> where T:IsmeGoreSecVeSirala{


        return list.filter {item->
            item.ad.lowercase().contains(ad.lowercase())
        }


    }


}