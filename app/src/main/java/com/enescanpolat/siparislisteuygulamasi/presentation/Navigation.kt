package com.enescanpolat.siparislisteuygulamasi.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.enescanpolat.siparislisteuygulamasi.presentation.Siparis.SiparisScreen
import com.enescanpolat.siparislisteuygulamasi.presentation.SiparisTeslimSec.SiparisTeslimSecScreen
import com.enescanpolat.siparislisteuygulamasi.presentation.SiparisUrunSec.SiparisUrunSecScren

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigation() {


    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ScreenRoutes.SiparisScreen.route
    ){
        composable(ScreenRoutes.SiparisScreen.route){
            SiparisScreen(navController=navController)
        }
        composable(ScreenRoutes.SiparisTeslimatSecScreen.route){
            SiparisTeslimSecScreen(navController = navController)
        }
        composable(ScreenRoutes.SiparisUrunSecScreen.route+"/{teslimatciId}"){
            SiparisUrunSecScren(
                navController = navController,
                teslimatciId = it.arguments?.getString("teslimatciId"))
        }


    }

}


sealed class ScreenRoutes(val route:String){

    object SiparisScreen:ScreenRoutes("siparis_screen")
    object SiparisTeslimatSecScreen:ScreenRoutes("siparis_teslimat_sec_screen")
    object SiparisUrunSecScreen:ScreenRoutes("siparis_urun_sec_screen")


}