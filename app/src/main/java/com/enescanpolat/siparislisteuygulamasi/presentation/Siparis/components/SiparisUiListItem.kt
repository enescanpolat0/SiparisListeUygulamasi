package com.enescanpolat.siparislisteuygulamasi.presentation.Siparis.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enescanpolat.siparislisteuygulamasi.presentation.Siparis.state.SiparisListItem
import com.enescanpolat.siparislisteuygulamasi.ui.theme.White

@Composable
fun SiparisUiListItem(
    siparisListItem: SiparisListItem,
    modifier: Modifier = Modifier

) {
    
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                siparisListItem.teslimtciAdi,
                fontWeight = FontWeight.Bold,
                color = White,
                fontSize = 20.sp
            )
            Text(
                "%.2f".format(siparisListItem.toplamTutar)+" $",
                fontWeight = FontWeight.Bold,
                color = White,
                fontSize = 20.sp
            )

        }
        Divider(color = White)
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ){
            Text(
                siparisListItem.siparisTarihi,
                color = White,
                fontSize = 16.sp
            )
        }
        
        
    }
    
    
}