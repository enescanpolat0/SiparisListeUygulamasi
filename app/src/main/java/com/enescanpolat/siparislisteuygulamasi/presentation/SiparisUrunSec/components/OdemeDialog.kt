package com.enescanpolat.siparislisteuygulamasi.presentation.SiparisUrunSec.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
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
import com.enescanpolat.siparislisteuygulamasi.presentation.Siparis.state.UrunListItem
import com.enescanpolat.siparislisteuygulamasi.ui.theme.Orange
import com.enescanpolat.siparislisteuygulamasi.ui.theme.White

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun OdemeDialog(
    reddetmek :()->Unit,
    kabuletmek:()->Unit,
    secilenUrunler:List<UrunListItem>
) {

    Dialog(
        onDismissRequest = { reddetmek() },
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        )
    ) {

        Card(
            elevation = 5.dp,
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .fillMaxHeight(0.8f)
                .border(1.dp, color = Orange, shape = RoundedCornerShape(15.dp))
        ) {
            
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Column {
                    Text(
                        text = "Cikis yap",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Divider(modifier = Modifier.padding(10.dp))
                    if (secilenUrunler.isNotEmpty()){

                        LazyColumn(
                            verticalArrangement = Arrangement.spacedBy(15.dp),
                            modifier = Modifier
                                .padding(top = 15.dp)
                        ){
                            items(
                                secilenUrunler,
                                key={urunListItem->
                                    urunListItem.id
                                }
                            ){
                                Row (
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ){
                                    Text(
                                        "${it.secilenMiktar}x"+it.ad
                                    )
                                    Text(
                                        "%.2f".format(it.adetFiyati*it.secilenMiktar)+" $"
                                    )


                                }
                            }
                        }


                    }else{
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ){
                            Text(text = "Lutfen Siparis Vereceginiz Urunleri Seciniz.")
                        }
                    }
                }
                
                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Divider()
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(text = "Toplam", fontWeight = FontWeight.Bold)
                        Text("%.2f".format(secilenUrunler.sumOf { (it.secilenMiktar*it.adetFiyati).toDouble() })+" $",
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Row(modifier = Modifier
                        .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(30.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(
                            onClick = { reddetmek() },
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Orange,
                                contentColor = White
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f),
                            shape = CircleShape
                        ) {

                            Text(
                                text="Geri",
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            )

                        }

                        Button(
                            onClick = { kabuletmek() },
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Orange,
                                contentColor = White
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f),
                            shape = CircleShape
                        ) {

                            Text(
                                text="Kabul",
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            )

                        }



                    }

                }

            }

        }


    }

}