package com.example.instagramclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.instagramclone.ui.theme.InstagramCloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstagramCloneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    var selectedTabIndex by remember {
                        mutableStateOf(0)
                    }
                    when(selectedTabIndex){
                        0-> HomeScreen()
                        1-> SearchScreen()
                        2->ReelsView()
                        3-> NotificationScreen()
                        4-> ProfileScreen()
                    }
                    Row(modifier = Modifier.fillMaxHeight(), horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.Bottom) {

                        Tabs(modifier = Modifier ,Icons){selectedTabIndex=it}
                    }
                }
            }
        }
    }
}
data class IconWithText(
    val image:Int,
    val desc:String
)

val Icons= listOf(
    IconWithText( R.drawable.home,"Home"),
    IconWithText( R.drawable.search,"Search"),
    IconWithText( R.drawable.reels,"Reels"),
    IconWithText( R.drawable.love,"Love"),
    IconWithText( R.drawable.user,"User"),
)

@Composable
fun Tabs(modifier: Modifier,iconTexts:List<IconWithText>,onTabSelected:(SelectedIndex:Int)->Unit){
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val inActiveColor= Color(0xff77777777)
    TabRow(
        selectedTabIndex = selectedTabIndex,
        backgroundColor = Color.White,
        contentColor = Color.Black,
        modifier = Modifier
    ) {
        iconTexts.forEachIndexed { index, item ->
            Tab(selected = selectedTabIndex==index,
                selectedContentColor = Color.Black, unselectedContentColor = inActiveColor,
                onClick = {
                    selectedTabIndex=index
                    onTabSelected(index)
                }) {
                Icon(painter = painterResource(id = item.image), contentDescription = item.desc,
                    tint=if(selectedTabIndex==index)Color.Black else inActiveColor,
                     modifier = Modifier
                         .padding(15.dp)
                         .size(20.dp))
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    InstagramCloneTheme {
        var selectedTabIndex by remember {
            mutableStateOf(0)
        }
        when(selectedTabIndex){
            0-> HomeScreen()
            1-> SearchScreen()
            2-> ReelsView()
            3-> NotificationScreen()
            4-> ProfileScreen()
        }
        Row(modifier = Modifier.fillMaxHeight(), horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom) {

            Tabs(modifier = Modifier ,Icons){selectedTabIndex=it}
        }
    }
}