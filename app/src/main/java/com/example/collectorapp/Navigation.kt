package com.example.collectorapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.collectorapp.ui.screens.Authentication.AuthenticationViewModel
import com.example.collectorapp.ui.screens.Authentication.SignIn.LoginInterface
import com.example.collectorapp.ui.screens.Authentication.Signup.RegisterInterface
import com.example.collectorapp.ui.screens.Categories.AddCategoryViewModel
import com.example.collectorapp.ui.screens.Categories.UserCategoryInput
import com.example.collectorapp.ui.screens.Items.AddItems.AddingItems
import com.example.collectorapp.ui.screens.Items.AddItemsViewModel

@Composable
fun NavigateAuth(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = "create_items",
    signInViewModel: AuthenticationViewModel,
    addCategoryViewModel: AddCategoryViewModel,
    addItemsViewModel: AddItemsViewModel
){
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ){
        composable("login_interface"){
            LoginInterface(signInViewModel, navController)
        }
        composable("registration_interface"){
            RegisterInterface(authenticationViewModel = signInViewModel, navController = navController)
        }
        composable("home"){
            MyBottomAppBar(signInViewModel = signInViewModel)
        }
        composable(route = "create_category"){
            UserCategoryInput(addCategoryViewModel, navController = navController)
        }
        composable(route = "create_items"){
            AddingItems(addItemsViewModel = addItemsViewModel)
        }
    }

}