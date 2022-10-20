package com.example.instagramclone

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


val postImages = listOf( R.drawable.post1,
 R.drawable.post2,
 R.drawable.bg1,
 R.drawable.ckay,
 R.drawable.post5,
    R.drawable.cat,
    R.drawable.profile2,
    R.drawable.post7,
    R.drawable.profile3,
    R.drawable.profile7,
    R.drawable.download,
    R.drawable.post4,
    R.drawable.post3,
    R.drawable.post7,
    R.drawable.post2,
    R.drawable.post5,
    R.drawable.cat,
    R.drawable.profile3,
    R.drawable.profile2,
    R.drawable.download,
    R.drawable.profile7,

)

@Composable
fun SearchScreen(){
    Column {
        Row(modifier = Modifier
            .background(Color.White)
            .padding(10.dp)) {
            SearchBar()
        }
        PostsSection(posts = postImages, modifier = Modifier)
    }
}

@Composable
fun SearchBar(){
    Row(modifier = Modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(10.dp))
        .background(colorResource(id = R.color.teal_700))
        .padding(horizontal = 10.dp, vertical = 7.dp), verticalAlignment = Alignment.CenterVertically) {
        Image(painter = painterResource(id = R.drawable.search), contentDescription = "search")
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = "Search", color = Color.Gray, fontSize = 15.sp)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PostsSection(posts:List<Int>, modifier: Modifier){
    LazyVerticalGrid(cells = GridCells.Fixed(3), modifier = Modifier.scale(1.01f)){
        items(posts.size){
            Image(painter = painterResource(id = posts[it]), contentDescription = null, contentScale = ContentScale.Crop, modifier = Modifier
                .aspectRatio(1f)
                .border(width = 2.dp, color = Color.White))
        }
    }
    Spacer(modifier = Modifier.height(40.dp))
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SearchScreenPreview(){
    Column {
        SearchScreen()
    }
}