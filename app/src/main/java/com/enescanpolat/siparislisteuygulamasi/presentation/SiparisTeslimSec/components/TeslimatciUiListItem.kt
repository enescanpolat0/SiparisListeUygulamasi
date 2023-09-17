package com.enescanpolat.siparislisteuygulamasi.presentation.SiparisTeslimSec.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.enescanpolat.siparislisteuygulamasi.presentation.SiparisTeslimSec.SiparisTeslimSecViewModel
import com.enescanpolat.siparislisteuygulamasi.presentation.SiparisTeslimSec.state.TeslimatciListItem
import com.enescanpolat.siparislisteuygulamasi.ui.theme.White

@Composable
fun TeslimatciUiListItem(
    teslimatciListItem: TeslimatciListItem,
    modifier : Modifier
) {

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            teslimatciListItem.ad,
            color = White
        )
        Icon(
            imageVector = Icons.Default.ArrowForward,
            contentDescription = "sag_ok",
            tint = White
        )

    }

}