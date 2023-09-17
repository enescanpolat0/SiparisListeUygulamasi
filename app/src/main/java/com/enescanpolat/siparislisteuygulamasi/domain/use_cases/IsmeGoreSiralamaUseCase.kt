package com.enescanpolat.siparislisteuygulamasi.domain.use_cases

import com.enescanpolat.siparislisteuygulamasi.domain.IsmeGoreSecVeSirala

class IsmeGoreSiralamaUseCase {



    operator fun <T> invoke(list:List<T>):List<T> where T:IsmeGoreSecVeSirala{
        return list.sortedBy {item->
            item.ad
        }
    }

}