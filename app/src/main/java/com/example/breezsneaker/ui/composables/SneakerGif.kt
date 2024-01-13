package com.example.breezsneaker.ui.composables

import android.widget.ImageView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.bumptech.glide.Glide
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
        AndroidView(
            factory = { ctx ->
                ImageView(ctx).apply {
                    Glide.with(ctx)
                        .asGif()
                        .load(sneakerGifRes)
                        .into(this)
                }
            },
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Box(modifier = Modifier.background(Color.Gray), contentAlignment = Alignment.Center) {
        SneakerGif(sneakerGifRes = R.drawable.shoe_pink)
    }
}
