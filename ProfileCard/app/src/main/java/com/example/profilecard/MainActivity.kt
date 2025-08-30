package com.example.profilecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profilecard.ui.theme.Comfortaa
import com.example.profilecard.ui.theme.ProfileCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfileCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProfileCard(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun IconAndName(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(0.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.padding(start = 100.dp, end = 100.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = "Android Logo",
                modifier = Modifier
                    .padding(20.dp)
                    .background(
                        Color
                            (0xff7f849c), shape =
                            RoundedCornerShape(40.dp)
                    )
                    .aspectRatio(1F)
            )

        }
        Text(
            text = "Davis Cartagena",
            color = Color(0xffcdd6f4),
            modifier = Modifier.padding(start = 80.dp, end = 80.dp),
            fontSize = 25.sp,
            fontFamily = Comfortaa,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Android Developer Extraordinaire",
            color = Color(0xff74c7ec),
            modifier = Modifier.padding(
                start = 80.dp,
                end = 80.dp,
                top = 10.dp
            ),
            fontSize = 12.sp,
            fontFamily = Comfortaa,
            fontWeight = FontWeight.Bold
        )

    }
}

@Composable
fun ContactZone(modifier: Modifier) {
    Column(
        modifier = modifier.padding(top = 200.dp),
        verticalArrangement = Arrangement.Bottom
    ) {
        ContactElement(
            modifier = modifier.padding(top = 20.dp),
            type = ContactType.PHONE
        )
        ContactElement(
            modifier = modifier.padding(top = 20.dp),
            type = ContactType.EMAIL
        )
        ContactElement(
            modifier = modifier.padding(top = 20.dp),
            type = ContactType.GITHUB
        )
    }
}

enum class ContactType {
    PHONE, EMAIL, GITHUB
}

@Composable
fun ContactElement(modifier: Modifier, type: ContactType) {
    val icon = when (type) {
        ContactType.PHONE -> Icons.Default.Phone
        ContactType.EMAIL -> Icons.Default.Email // Replace with email icon
        ContactType.GITHUB -> Icons.Default.AccountCircle
    }
    val text = when (type) {
        ContactType.PHONE -> "+51 903 263 148"
        ContactType.EMAIL -> "daviscvb22092004@gmail.com"
        ContactType.GITHUB -> "github.com/DavisLCVB"
    }
    Row(
        modifier = Modifier.padding(top = 10.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "Contact Icon",
            tint = Color(0xff74c7ec),
            modifier = Modifier.weight(1F)
        )
        Text(
            text = text,
            color = Color(0xffcdd6f4),
            modifier = Modifier
                .padding(start = 10.dp)
                .weight(4F),
            fontSize = 12.sp,
            fontFamily = Comfortaa,
            fontWeight = FontWeight.Normal
        )
    }
}

@Composable
fun ProfileCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(Color(0xff1e1e2e))
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        IconAndName(modifier = modifier.padding(top = 20.dp))
        ContactZone(
            modifier = modifier
                .padding(start = 40.dp, end = 40.dp, top = 40.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProfileCardTheme {
        ProfileCard()
    }
}