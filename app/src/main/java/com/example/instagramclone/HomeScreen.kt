package com.example.instagramclone

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Story(
    val id: Int,
    val imageRes : Int,
    val name: String,
)



val storiesList= listOf(
    Story(
        1,
        R.drawable.img1,
        "Marcus clarke"
    ),
    Story(
        2,
        R.drawable.profile2,
        "Liva sage"
    ),
    Story(
        3,
        R.drawable.profile7,
        "Camillie"
    ),
    Story(
        4,
        R.drawable.post1,
        "Emily"
    ),
    Story(
        5,
        R.drawable.post2,
        "Robert evans"
    ),
    Story(
        6,
        R.drawable.profile3,
        "Salena lily"
    ),
)

data class Post(
    val image:Int,
    val name:String,
    val postImage:Int,
    val likes:Int,
    val caption:String,
    val comments:Int,
    val days:String
)


val postDetails= listOf(
    Post(R.drawable.img1,"Marcus clarke",R.drawable.bg1,90,"Cyberpunk City...😍",20,"2 hours ago"),
    Post(R.drawable.profile2,"Liva sage",R.drawable.post7,590,"Artistic glitters ✨",38,"5 hours ago"),
    Post(R.drawable.profile7,"camillie",R.drawable.post4,712,"Aesthetic view...🤩",40,"10 hours ago"),
    Post(R.drawable.post1,"Emily",R.drawable.post5,958,"♥️",70,"1 day ago"),
    Post(R.drawable.post2,"Robert evans",R.drawable.post6,990,"The Blue looking Beast...💙",144,"2 days ago"),
)






@Composable
fun HomeScreen(){
    Column(modifier = Modifier) {
        HomeTabBar()
        StoriesList(storiesList = storiesList)
        PostCardsList(postDetails = postDetails)
    }
}

@Composable
fun HomeTabBar(){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp) ,verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
        Image(painter = painterResource(id =R.drawable.instagram_text ),
            contentDescription = null)
        Row() {
            Image(painter = painterResource(id = R.drawable.plus), contentDescription =null )
            Spacer(modifier = Modifier.width(10.dp))
            Image(painter = painterResource(id = R.drawable.send), contentDescription =null ,
                modifier = Modifier.size(23.dp))
        }
    }
}

@Composable
fun StoriesList(storiesList:List<Story>){
    LazyRow(contentPadding = PaddingValues(5.dp), modifier = Modifier){
        item(storiesList){
            AddStory(image = R.drawable.main, text = "Your story")
        }
        items(storiesList){story->
            Stories(story.imageRes,story.name)
        }
    }
}

@Composable
fun Stories(image:Int,text:String){
    Column(modifier = Modifier
        .wrapContentSize()
        .padding(horizontal = 5.dp)) {
        Image(painter = painterResource(id = image) , contentDescription =null, modifier = Modifier
            .size(80.dp)
            .border(
                width = 2.dp, color = Color.Magenta, shape = CircleShape
            )
            .padding(4.dp)
            .clip(CircleShape), contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(3.dp))
        Text(text =text, modifier = Modifier.width(85.dp)
            , maxLines = 1, textAlign = TextAlign.Center, fontSize = 12.sp)
    }
}
@Composable
fun AddStory(image:Int,text:String){
    Column(modifier = Modifier
        .wrapContentSize()
        .padding(horizontal = 5.dp)) {
        Box(modifier =Modifier ){
            Image(painter = painterResource(id = image) , contentDescription =null, modifier = Modifier
                .size(80.dp)
                .padding(4.dp)
                .clip(CircleShape)
            )
            Text(
                modifier = Modifier
                    .align(alignment = Alignment.BottomEnd)
                    .padding(end = 4.dp, top = 0.dp, bottom = 5.dp, start = 0.dp)
                    .drawBehind {
                        drawCircle(
                            color = Color.Magenta,
                            radius = this.size.minDimension
                        )
                    },
                text = "+", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
        }
        Spacer(modifier = Modifier.height(3.dp))
        Text(text =text, modifier = Modifier.width(85.dp)
            , maxLines = 1, textAlign = TextAlign.Center, fontSize = 12.sp)
    }
}

@Composable
fun PostCardsList(postDetails:List<Post>){
    LazyColumn(){
        items (postDetails){item->
            PostCards(
                name = item.name,
                img1 = item.image,
                img2 = item.postImage,
                likes = item.likes,
                comments = item.comments,
                days = item.days,
                caption = item.caption
            )
        }
    }
    Spacer(modifier = Modifier.height(40.dp))
}

@Composable
fun PostCards(name:String,img1:Int,img2:Int,likes:Int,comments:Int,days:String,caption:String){
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp, horizontal = 8.dp), verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource(id = img1) , contentDescription =null, modifier = Modifier
                .size(45.dp)
                .border(
                    width = 2.dp, color = Color.Magenta, shape = CircleShape
                )
                .padding(4.dp)
                .clip(CircleShape), contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text =name, modifier = Modifier.wrapContentSize()
                , maxLines = 1, textAlign = TextAlign.Center, fontWeight = FontWeight.Bold,fontSize = 16.sp)
            Spacer(modifier = Modifier.weight(1f))
            Image(painter = painterResource(id = R.drawable.menu) , contentDescription ="menu", modifier = Modifier.size(20.dp))
        }
        Image(painter = painterResource(id = img2),
            contentDescription ="PostImage" , modifier = Modifier
                .fillMaxWidth()
                .height(350.dp), contentScale = ContentScale.Crop)

        Row(modifier = Modifier.padding(10.dp)) {
            Image(painter = painterResource(id = R.drawable.love), contentDescription = "likes", modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp))
            Image(painter = painterResource(id = R.drawable.coment) , contentDescription ="Comment", modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp) )
            Image(painter = painterResource(id = R.drawable.send) , contentDescription = "Share", modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 3.dp)
                .size(21.dp))
            Spacer(modifier = Modifier.weight(1f))
            Image(painter = painterResource(id = R.drawable.save), contentDescription ="Save", modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp) )
        }
        Text(text = "$likes likes", modifier = Modifier.padding(horizontal = 10.dp), fontWeight = FontWeight.Bold, fontSize = 15.sp)
        Row(modifier = Modifier.padding(horizontal = 10.dp)) {
            Text(text = name, modifier = Modifier, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.width(7.dp))
            Text(text = caption)
        }
        Spacer(modifier = Modifier.height(3.dp))
        Text(text = "View all $comments comments",Modifier.padding(horizontal = 10.dp), color = Color.Gray)
        Text(text = days,Modifier.padding(horizontal = 10.dp), color = Color.Gray, fontSize = 10.sp)
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview(){
    Column(modifier = Modifier.fillMaxSize()) {
        HomeTabBar()
        StoriesList(storiesList = storiesList)
        PostCardsList(postDetails = postDetails)
    }
}
