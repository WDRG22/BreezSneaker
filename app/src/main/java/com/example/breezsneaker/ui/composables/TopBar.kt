package com.example.breezsneaker.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.breezsneaker.R

@Composable
fun TopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .height(122.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.breez_logo_white),
            contentDescription = "BREEZ Logo",
            modifier = Modifier
                .align(Alignment.Center)
                .padding(vertical = 32.dp)
        )
    }
}