package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.FontScaling
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ComposeQuadrant(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Quadrant(num: Int = 4, modifier: Modifier) {
    val title = when (num) {
        1 -> R.string.Q1Title
        2 -> R.string.Q2Title
        3 -> R.string.Q3Title
        else -> R.string.Q4Title
    }
    val description = when (num) {
        1 -> R.string.Q1Desc
        2 -> R.string.Q2Desc
        3 -> R.string.Q3Desc
        else -> R.string.Q4Desc
    }
    val color = when (num) {
        1 -> Color(0xFFEADDFF)
        2 -> Color(0xFFD0BCFF)
        3 -> Color(0xFFB69DF8)
        else -> Color(0xFFF6EDFF)
    }
    Box(
        modifier = modifier.background(color = color)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = stringResource(id = title),
                modifier = Modifier.padding(bottom = 16.dp),
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = stringResource(id = description),
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Composable
fun ComposeQuadrant(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().weight(1f)
        ) {
            Quadrant(1, Modifier.weight(1f))
            Quadrant(2, Modifier.weight(1f))
        }
        Row (
            modifier = Modifier.fillMaxWidth().weight(1f)
        ){
            Quadrant(3, Modifier.weight(1f))
            Quadrant(4, Modifier.weight(1f))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        ComposeQuadrant(modifier = Modifier)
    }
}