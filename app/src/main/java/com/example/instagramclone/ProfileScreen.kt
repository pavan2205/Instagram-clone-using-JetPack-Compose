package com.example.instagramclone

import android.graphics.Paint
import android.graphics.drawable.RippleDrawable
import android.widget.Space
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val highl= listOf(
    Highlight(
        1,
        R.drawable.sethrollins,
        "wwe"
    ),
    Highlight(
        2,
        R.drawable.sethrollins,
        "wwe"
    ),
    Highlight(
        3,
        R.drawable.sethrollins,
        "wwe"
    ),
    Highlight(
        4,
        R.drawable.sethrollins,
        "wwe"
    ),
    Highlight(
        5,
        R.drawable.sethrollins,
        "wwe"
    ),
    Highlight(
        6,
        R.drawable.sethrollins,
        "wwe"
    ),
)

val tabsdetails= listOf(
    ImageWithText(R.drawable.grid,"grid"),
    ImageWithText(R.drawable.reels,"reels"),
    ImageWithText(R.drawable.profile,"profile")
)
@Composable
fun ProfileScreen(){
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(6.dp))
        TopBar(name = "SethRollins22 _offical", modifier = Modifier)
        Spacer(modifier = Modifier.height(9.dp))
        ProfileSection(modifier = Modifier)
        ProfileDescription(displayName = "Seth Rollins", description = "Currently pursuing a Bachelor's, Master's or PhD degree in Computer Science or related technical field" )
        Spacer(modifier = Modifier.height(5.dp))
        HighlightsSection(highl)
        Spacer(modifier = Modifier.heightIn(7.dp))
        IconsColumn(modifier = Modifier, tabsdetails){selectedTabIndex=it}
        when(selectedTabIndex){
            0-> PostSection(posts = listOf(
                painterResource(id =R.drawable.sethrollins ),
                        painterResource(id =R.drawable.sethrollins ),
                        painterResource(id = R.drawable.sethrollins),
                        painterResource(id = R.drawable.sethrollins),
                        painterResource(id = R.drawable.sethrollins),
                        painterResource(id = R.drawable.sethrollins),
                painterResource(id = R.drawable.sethrollins)
            ) , modifier = Modifier)

            1-> PostSection(posts = listOf(
                painterResource(id = R.drawable.naruto),
                painterResource(id = R.drawable.naruto),
                painterResource(id = R.drawable.naruto),
                painterResource(id = R.drawable.naruto),
                painterResource(id = R.drawable.naruto),
            ), modifier = Modifier)

            2-> PostSection(posts = listOf(
                painterResource(id = R.drawable.cat),
                painterResource(id = R.drawable.cat),
                painterResource(id = R.drawable.cat),
                painterResource(id = R.drawable.cat),
                painterResource(id = R.drawable.cat),
            ), modifier = Modifier)
        }
    }
}

@Composable
fun TopBar(name:String,modifier: Modifier=Modifier){
    Row(verticalAlignment =Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceAround, modifier = modifier       .fillMaxWidth()) {
        Icon(imageVector = Icons.Default.ArrowBack, contentDescription ="Back", tint = Color.Black, modifier = Modifier.size(24.dp))
        Text(text = name, overflow = TextOverflow.Ellipsis, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Icon(painter = painterResource(id = R.drawable.ic_bell), contentDescription = "notification bell")
        Icon(painter = painterResource(id = R.drawable.ic_dotmenu), contentDescription = "menu")
    }
}

@Composable
fun RoundImage(image:Painter,modifier: Modifier=Modifier){
    Image(painter = image , contentDescription =null, modifier = Modifier
        .size(95.dp)
        .border(
            width = 1.dp, color = Color.LightGray, shape = CircleShape
        )
        .padding(3.dp)
        .clip(CircleShape)
    )
}

@Composable
fun ProfileSection(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            RoundImage(
                image = painterResource(id = R.drawable.sethrollins),
                modifier = Modifier
                    .size(70.dp)
                    .weight(3f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            StatSection(modifier = Modifier.weight(7f))
        }
    }
}
@Composable
fun StatSection(modifier: Modifier=Modifier){
    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceAround, modifier = modifier){
        ProfileStat(numberText = "700", text ="Posts")
        ProfileStat(numberText = "150k", text = "Followers")
        ProfileStat(numberText = "48", text = "Following")
    }
}

@Composable
fun ProfileStat(
    numberText: String,
    text: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = numberText,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = text)
    }
}

@Composable
fun ProfileDescription(
    displayName:String,
    description:String,
){
    val letterSpacing=0.5.dp;
    val lineHeight=20.sp;
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = displayName,
            fontWeight = FontWeight.Bold,
            lineHeight = lineHeight
        )
        Text(text = description, lineHeight = lineHeight)
        Spacer(modifier = Modifier.height(4.dp))
        Button(  onClick = { /*TODO*/ },colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.LightGray)) {
            Text(text = "Edit profile", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, color = Color.Black)
        }
    }
}
data class Highlight(
    val id: Int,
    val imageRes : Int,
    val description: String,
)

data class ImageWithText(
    val image:Int,
    val text:String
)

@Composable
fun HighlightsSection(highlight:List<Highlight>){
    LazyRow(
            contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)){
        items(highlight) {arrayItem->
            HighLight(image = arrayItem.imageRes, text =arrayItem.description )
            Spacer(modifier = Modifier.width(10.dp))
        }
    }
}

@Composable
fun HighLight(image:Int,text:String){
    Column(modifier = Modifier.wrapContentSize()) {
        Image(painter = painterResource(id = image) , contentDescription =null, modifier = Modifier
            .size(80.dp)
            .border(
                width = 1.dp, color = Color.LightGray, shape = CircleShape
            )
            .padding(4.dp)
            .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(3.dp))
        Text(text =text, modifier = Modifier.width(70.dp), textAlign = TextAlign.Center)
    }
}
@Composable
fun IconsColumn(modifier: Modifier,imageWithtexts:List<ImageWithText>,onTabSelected:(selectedIndex:Int)->Unit){
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val inActiveColor=Color(0xff77777777)
    TabRow(selectedTabIndex = selectedTabIndex, backgroundColor = Color.Transparent, contentColor = Color.Black, modifier = Modifier) {
        imageWithtexts.forEachIndexed { index, item ->
            Tab(selected = selectedTabIndex == index,
                selectedContentColor = Color.Black,
                unselectedContentColor = inActiveColor,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
                }) {
                Icon(
                    painter = painterResource(id =item.image),
                    contentDescription = item.text,
                    tint = if (selectedTabIndex == index) Color.Black else inActiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }
        }
    }
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PostSection(posts:List<Painter>,modifier: Modifier){
    LazyVerticalGrid(cells = GridCells.Fixed(3), modifier = Modifier.scale(1.01f)){
        items(posts.size){
            Image(painter = posts[it], contentDescription = null, contentScale = ContentScale.Crop, modifier = Modifier
                .aspectRatio(1f)
                .border(width = 1.dp, color = Color.White))
        }
    }
}