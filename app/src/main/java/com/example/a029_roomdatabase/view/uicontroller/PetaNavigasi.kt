package com.example.a029_roomdatabase.view.uicontroller

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.a029_roomdatabase.view.DetailSiswaScreen
import com.example.a029_roomdatabase.view.EntrySiswaScreen
import com.example.a029_roomdatabase.view.HomeScreen
import com.example.a029_roomdatabase.view.route.DestinasiDetailSiswa
import com.example.a029_roomdatabase.view.route.DestinasiDetailSiswa.itemIdArg
import com.example.a029_roomdatabase.view.route.DestinasiEntry
import com.example.a029_roomdatabase.view.route.DestinasiHome
import com.example.a029_roomdatabase.viewmodel.DetailSiswa

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SiswaApp(navController: NavHostController, modifier: Modifier = Modifier) {
    HostNavigasi(navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    NavHost(navController=navController,
        startDestination = DestinasiHome.route,
        modifier = Modifier
    ) {
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemUpdate = { navController.navigate("${DestinasiDetailSiswa.route}/$it")},
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
            )
        }
        composable(DestinasiEntry.route) {
            EntrySiswaScreen(navigateBack = { navController.popBackStack() })
        }

        composable(route = DestinasiDetailSiswa.routeWithArgs,
            arguments = listOf(navArgument(itemIdArg) {
                type = NavType.IntType
            })
        ){
            DetailSiswaScreen(
                //navigateToEditItem = {navController.navigate("${DestinasiEditSsiswa.route}/$it")},
                navigateBack = { navController.navigateUp() })
        }
    }
}