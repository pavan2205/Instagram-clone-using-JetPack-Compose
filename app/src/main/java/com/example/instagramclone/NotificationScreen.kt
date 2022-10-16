package com.example.instagramclone

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val Thisweekl= listOf(
    ThisWeekNotification(R.drawable.sethrollins,"Pavan","liked"),
    ThisWeekNotification(R.drawable.sethrollins,"Pavan","comment"),
    ThisWeekNotification(R.drawable.sethrollins,"Pavan","following"),
    ThisWeekNotification(R.drawable.sethrollins,"Pavan","follow"),
    ThisWeekNotification(R.drawable.sethrollins,"Pavan","liked"),
    ThisWeekNotification(R.drawable.sethrollins,"Pavan","liked"),
    ThisWeekNotification(R.drawable.sethrollins,"Pavan","liked"),
    ThisWeekNotification(R.drawable.sethrollins,"Pavan","comment"),
    ThisWeekNotification(R.drawable.sethrollins,"Pavan","liked"),
    ThisWeekNotification(R.drawable.sethrollins,"Pavan","comment"),
    ThisWeekNotification(R.drawable.sethrollins,"Pavan","comment"),
    ThisWeekNotification(R.drawable.sethrollins,"Pavan","comment"),
)
@Composable
fun NotificationScreen(){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 10.dp)) {
        Text(text = "Notifications", fontSize = 25.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 5.dp, vertical = 10.dp))
        FollowRequests()
        Spacer(modifier = Modifier.height(7.dp))
        Text(text = "This Week", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(7.dp))
        ThisWeekList(Thisweekl)
    }
}

@Composable
fun FollowRequests(){
    Row(modifier = Modifier
        .fillMaxWidth()
        ) {
        Box(modifier =Modifier ){
            Image(painter = painterResource(id = R.drawable.sethrollins) , contentDescription =null, modifier = Modifier
                .size(60.dp)
                .border(
                    width = 1.dp, color = Color.LightGray, shape = CircleShape
                )
                .padding(3.dp)
                .clip(CircleShape)
            )
            Text(
                modifier = Modifier
                    .align(alignment = Alignment.TopEnd)
                    .padding(vertical = 10.dp)
                    .drawBehind {
                        drawCircle(
                            color = Color.Red,
                            radius = this.size.minDimension
                        )
                    },
                text = "200", color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold)
        }

        Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 5.dp)) {
            Text(text = "Follow requests", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.Black)
            Text(text = "Approve or ignore requests", fontSize = 14.sp,color = Color.Gray)
        }
    }
}
data class ThisWeekNotification(
    val image:Int,
    val name:String,
    val notificationType: String
)

@Composable
fun ThisWeekList(Thisweek:List<ThisWeekNotification>){
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(5.dp)){
        items(Thisweek) {arrayItem->
            ThisWeekNotification(image = arrayItem.image, name =arrayItem.name, notificationType = arrayItem.notificationType, modifier = Modifier )
        }
    }
}
@Composable
fun ThisWeekNotification(image:Int,name:String,notificationType:String,modifier: Modifier){
    when(notificationType){
        "following"->Row(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 3.dp), verticalAlignment = Alignment.CenterVertically){
            Row(verticalAlignment = Alignment.CenterVertically){
                Image(painter = painterResource(id = image) , contentDescription =null, modifier = Modifier
                    .size(60.dp)
                    .border(
                        width = 1.dp, color = Color.LightGray, shape = CircleShape
                    )
                    .padding(3.dp)
                    .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    buildAnnotatedString {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Black)) {
                            append(name)
                        }
                        append(" started following you.")
                    }
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(onClick = { },colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.LightGray)) {
                Text(text = "Following", color = Color.Black)
            }
        }
        "follow"->Row(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 3.dp), verticalAlignment = Alignment.CenterVertically){
            Row(verticalAlignment = Alignment.CenterVertically){
                Image(painter = painterResource(id = image) , contentDescription =null, modifier = Modifier
                    .size(60.dp)
                    .border(
                        width = 1.dp, color = Color.LightGray, shape = CircleShape
                    )
                    .padding(3.dp)
                    .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    buildAnnotatedString {
                        append("Follow ")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Black)) {
                            append(name)
                        }
                        append(" to see their posts.")
                    }
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(onClick = { /*TODO*/ },colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.blue_sky))) {
                Text(text = "Follow", color = Color.White)
            }
        }
        "liked"->Row(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 3.dp), verticalAlignment = Alignment.CenterVertically){
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(painter = painterResource(id =image) , contentDescription =null, modifier = Modifier
                    .size(60.dp)
                    .border(
                        width = 1.dp, color = Color.LightGray, shape = CircleShape
                    )
                    .padding(3.dp)
                    .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    buildAnnotatedString {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Black)) {
                            append(name)
                        }
                        append(" liked your post.")
                    }
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Image(painter = painterResource(id = R.drawable.sethrollins) , contentDescription = null,modifier=Modifier.size(50.dp))
        }
        "comment"->Row(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 3.dp), verticalAlignment = Alignment.CenterVertically){
            Row (verticalAlignment = Alignment.CenterVertically){
                Image(painter = painterResource(id = image) , contentDescription =null, modifier = Modifier
                    .size(60.dp)
                    .border(
                        width = 1.dp, color = Color.LightGray, shape = CircleShape
                    )
                    .padding(3.dp)
                    .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    buildAnnotatedString {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Black)) {
                            append(name)
                        }
                        append(" commented on your post.")
                    }
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Image(painter = painterResource(id = image) , contentDescription = null,modifier=Modifier.size(50.dp))
        }
    }
}