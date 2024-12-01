package com.example.buildui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buildui.ui.theme.BuildUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BuildUITheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color(0xFFDAE5DB))
                    ) {
                        MainBody(modifier = Modifier.padding(innerPadding))
                    }
                }
            }
        }
    }
}

@Composable
fun MainBody(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.logo)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.92f)
                .height(250.dp)
                .fillMaxHeight(0.1f)
                .padding(8.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = image,
                contentDescription = "logo-android",
                modifier = Modifier
                    .width(180.dp)
                    .height(155.dp)
            )
            Text(
                text = "Danfelogar Front",
                fontWeight = FontWeight.Normal,
                color = Color(0xFF121C16),
                fontSize = 43.sp
            )
            Text(
                text = "Android developer extraordinaire",
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF42674E),
                fontSize = 16.sp
            )
        }
        Spacer(modifier = Modifier.height(210.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth(0.92f)
//                .background(Color(0xFF008000))
                .height(130.dp)
                .fillMaxHeight(0.1f)
                .padding(8.dp),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            InformationCard(iconName = "phone",title = "+00 (00) 000 000")
            InformationCard(iconName = "share",title = "@socialmediahandle")
            InformationCard(iconName = "email",title = "email@domain.com")
        }
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
fun InformationCard(iconName:String ,title:String, modifier: Modifier = Modifier){
    val icon  = when (iconName) {
        "email" -> Icons.Rounded.Email
        "share" -> Icons.Rounded.Share
        "phone" -> Icons.Rounded.Call
        else -> Icons.Rounded.Home
    }
    Row(
        modifier = modifier
            .fillMaxWidth(0.99f)
            .height(31.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            icon,
            tint = Color(0xFF3A644B),
            contentDescription = iconName,
            modifier = Modifier
                .padding(start = 72.dp)
        )
        Text(
            text = title,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF242D28),
            modifier = Modifier
                .padding(start = 14.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BuildUITheme {
        MainBody()
    }
}
