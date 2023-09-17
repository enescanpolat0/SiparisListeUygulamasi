package com.enescanpolat.siparislisteuygulamasi.presentation.SiparisUrunSec

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.enescanpolat.siparislisteuygulamasi.presentation.ScreenRoutes
import com.enescanpolat.siparislisteuygulamasi.presentation.SiparisUrunSec.components.OdemeDialog
import com.enescanpolat.siparislisteuygulamasi.presentation.SiparisUrunSec.components.UrunUIListItem
import com.enescanpolat.siparislisteuygulamasi.ui.theme.Gray
import com.enescanpolat.siparislisteuygulamasi.ui.theme.Orange
import com.enescanpolat.siparislisteuygulamasi.ui.theme.White

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SiparisUrunSecScren(
    navController: NavController,
    teslimatciId:String?,
    siparisUrunSecViewModel: SiparisUrunSecViewModel = hiltViewModel()
    
) {
    
    LaunchedEffect(key1 = true){
        if (teslimatciId!=null){
            siparisUrunSecViewModel.initUrunList(teslimatciId)
        }
    }

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState=scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Urun Seciniz", color = White)
                },
                backgroundColor = Orange
            )
        },
        floatingActionButton = { 
            FloatingActionButton(onClick = {
                siparisUrunSecViewModel.onCheckOutClick()
            },
                backgroundColor = Orange
            ) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "fab_para",
                    tint = White,
                    modifier = Modifier
                        .size(32.dp)
                )

            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Gray)
                .padding(15.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value =siparisUrunSecViewModel.urunSearchQuery ,
                onValueChange ={
                    siparisUrunSecViewModel.onUrunSearchQueryChange(it)
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = White,
                    textColor = Gray,
                    cursorColor = Orange,
                    focusedLabelColor = Orange,
                    focusedIndicatorColor = Orange
                ),
                label = {
                    Text("Urun Arama")
                },
                maxLines = 1
            )
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .padding(top = 20.dp)
            ){
                items(
                    siparisUrunSecViewModel.urunleriGoster,
                    key = {urunListItem ->
                        urunListItem.id
                    }
                ){
                    UrunUIListItem(
                        urunListItem = it,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .border(1.dp, color = White, shape = RoundedCornerShape(10.dp))
                            .clickable {
                                siparisUrunSecViewModel.onListItemClick(it.id)
                            }
                            .padding(10.dp),
                        urunSatildi = it.urunSatildi,
                        onMinusClick = {
                            siparisUrunSecViewModel.onMinusClick(it.id)
                        },
                        onPlusClick = {
                            siparisUrunSecViewModel.onPlusClick(it.id)
                        }
                    )
                }
            }

        }
    }

    if (siparisUrunSecViewModel.gosterilenDiyalogaGozAt){
        OdemeDialog(
            reddetmek = {
                        siparisUrunSecViewModel.onDismissChecOutDialog()
            },
            kabuletmek = {
                         siparisUrunSecViewModel.onSatinAl()
                navController.navigate(ScreenRoutes.SiparisScreen.route){
                    popUpTo(0)
                }
            },
            secilenUrunler = siparisUrunSecViewModel.secilenUrunler
        )
    }


}