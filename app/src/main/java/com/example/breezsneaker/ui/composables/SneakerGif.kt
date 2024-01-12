package com.example.breezsneaker.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.breezsneaker.R
import com.example.breezsneaker.ui.theme.lighter_grey

@Composable
fun SneakerGif(sneakerGifRes: Int) {
    Box(
        modifier = Modifier
            .background(lighter_grey)
            .height(1452.dp),
        contentAlignment = Alignment.Center
    ){
        AsyncImage(
            model = sneakerGifRes,
            contentDescription = "Sneaker",
            modifier = Modifier
                .fillMaxSize()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Box(modifier = Modifier.background(Color.Gray), contentAlignment = Alignment.Center) {
        // Replace R.drawable.shoe_gif with your actual drawable resource ID
        SneakerGif(sneakerGifRes = R.drawable.shoe_pink)
    }
}