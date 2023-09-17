package com.enescanpolat.siparislisteuygulamasi.presentation.Siparis.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.enescanpolat.siparislisteuygulamasi.presentation.Siparis.state.SiparisDetayListeItem
import com.enescanpolat.siparislisteuygulamasi.ui.theme.Orange

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SiparisDetayDiyalog(
    onDissmiss:()->Unit,
    siparisDetayListeItem: SiparisDetayListeItem

) {
    Dialog(
        onDismissRequest = {
        onDissmiss()
    },
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        )
    ){
        Card(elevation =5.dp,
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .fillMaxHeight(0.8f)
                .border(1.dp, color = Orange, shape = RoundedCornerShape(15.dp))
            ) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(15.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column {
                    Text("Siparis kuryede ${siparisDetayListeItem.teslimatciadi}",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.fillMaxWidth()
                        )
                    Text(siparisDetayListeItem.siparisTarihi,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp)
                    )
                    Divider(modifier = Modifier.padding(top=10.dp))
                    
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(15.dp),
                        modifier = Modifier
                            .padding(top = 15.dp)
                    ){

                        items(
                            siparisDetayListeItem.urunler,
                            key = {UrunListItem ->
                                UrunListItem.id
                            }
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(text = "${it.secilenMiktar}x" + it.ad)
                                Text(text = "%.2f".format(it.adetFiyati*it.secilenMiktar)+" $")
                            }
                        }
                    }
                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Divider()
                    Row(modifier =Modifier
                        .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Toplam ", fontWeight = FontWeight.Bold)
                        Text(text = "%.2f".format(siparisDetayListeItem.urunler.sumOf { (it.secilenMiktar*it.adetFiyati).toDouble() })+" $",
                            fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
    
    
}