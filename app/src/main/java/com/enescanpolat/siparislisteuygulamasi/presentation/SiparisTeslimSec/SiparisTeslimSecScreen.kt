package com.enescanpolat.siparislisteuygulamasi.presentation.SiparisTeslimSec

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.enescanpolat.siparislisteuygulamasi.presentation.ScreenRoutes
import com.enescanpolat.siparislisteuygulamasi.presentation.SiparisTeslimSec.components.TeslimatciUiListItem
import com.enescanpolat.siparislisteuygulamasi.presentation.SiparisTeslimSec.state.TeslimatciListItem
import com.enescanpolat.siparislisteuygulamasi.ui.theme.Gray
import com.enescanpolat.siparislisteuygulamasi.ui.theme.Orange
import com.enescanpolat.siparislisteuygulamasi.ui.theme.White


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SiparisTeslimSecScreen(
    navController: NavController,
    siparisTeslimSecViewModel: SiparisTeslimSecViewModel = hiltViewModel()
) {

    val scaffoldState = rememberScaffoldState()
    
    
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Teslimatci Seciniz", color = White)
                },
                backgroundColor = Orange

            )
        }
    ) {

        Column(modifier = Modifier
            .fillMaxSize()
            .background(Gray)
            .padding(15.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = siparisTeslimSecViewModel.teslimatciSearchQuery,
                onValueChange = {
                    siparisTeslimSecViewModel.onAramaQueryChange(it)
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = White,
                    textColor = Gray,
                    cursorColor = Orange,
                    focusedLabelColor = Orange,
                    focusedIndicatorColor = Orange
                ),
                label = {
                    Text("Teslimatci Arama")
                },
                maxLines = 1
            )
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .padding(top = 20.dp)
                ){

                items(
                    siparisTeslimSecViewModel.teslimatcilariGoster,
                    key = {teslimatciListItem->
                        teslimatciListItem.teslimatciId
                    }
                ){

                    TeslimatciUiListItem(
                        it,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .border(1.dp,color = White, RoundedCornerShape(10.dp))
                            .clickable {
                                navController.navigate(ScreenRoutes.SiparisUrunSecScreen.route+"/${it.teslimatciId}")
                            }
                            .padding(15.dp)
                    )


                }


            }
        }
        

    }

}