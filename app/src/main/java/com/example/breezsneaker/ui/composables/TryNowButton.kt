package com.example.breezsneaker.ui.composables

import CustomType
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TryNowButton() {
    Button(
        onClick = { /* Handle click */ },
        colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
        shape = androidx.compose.foundation.shape.RoundedCornerShape(0.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 202.dp)
            .size(width = 1756.dp, height = 184.dp)

    ) {
        Text(
            "TRY NOW",
            style = CustomType.titleMedium.copy(color = Color.White)
        )
    }
}