package com.enescanpolat.siparislisteuygulamasi.presentation.Siparis

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.enescanpolat.siparislisteuygulamasi.presentation.ScreenRoutes
import com.enescanpolat.siparislisteuygulamasi.presentation.Siparis.components.SiparisDetayDiyalog
import com.enescanpolat.siparislisteuygulamasi.presentation.Siparis.components.SiparisUiListItem
import com.enescanpolat.siparislisteuygulamasi.ui.theme.Gray
import com.enescanpolat.siparislisteuygulamasi.ui.theme.Orange
import com.enescanpolat.siparislisteuygulamasi.ui.theme.White

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SiparisScreen(
    navController: NavController,
    siparisViewModel: SiparisViewModel= hiltViewModel()
) {

    val scaffoldState= rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        floatingActionButton = {
            FloatingActionButton(onClick = {
                                           navController.navigate(ScreenRoutes.SiparisTeslimatSecScreen.route)
            },
                backgroundColor = Orange
            ) {
                Icon(imageVector = Icons.Default.Add,
                    contentDescription = "fab_add_siparis",
                    tint = White
                    )

            }
        },
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Genel Siparis Toplami",
                        color = White
                        )
                },
                backgroundColor = Orange
            )
        }
    ){
        if (siparisViewModel.siparisList.isEmpty()){
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Siparisiniz Bulunamadi")
            }
        }else{
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Gray)
                    .padding(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ){
                items(
                    siparisViewModel.siparisList,
                    key={ sipariListItem->
                        sipariListItem
                    }
                ){
                    SiparisUiListItem(
                        it,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .border(1.dp, color = White, RoundedCornerShape(10.dp))
                            .clickable {
                                siparisViewModel.onSiparisClick(it.siparisId)
                            }
                            .padding(15.dp)
                    )
                }
            }
        }
    }

    if(siparisViewModel.siparisDiyalogGoster && siparisViewModel.tiklananSiparisItem !=null){
        SiparisDetayDiyalog(
            onDissmiss = { siparisViewModel.siparisDiylogKapat() },
            siparisDetayListeItem = siparisViewModel.tiklananSiparisItem!!)
    }
    
}