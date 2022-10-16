package com.example.instagramclone

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@Composable
fun HomeScreen(){
    Column(modifier = Modifier.fillMaxSize()) {
        HomeTabBar()
    }
}

@Composable
fun HomeTabBar(){
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
        Image(painter = painterResource(id =R.drawable.instagram_text ), contentDescription = null)
        Row {
            Image(painter = painterResource(id = R.drawable.plus), contentDescription =null )
            Image(painter = painterResource(id = R.drawable.send), contentDescription =null )
        }
    }
}