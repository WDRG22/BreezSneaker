package com.example.breezsneaker.ui.composables

import CustomType
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SneakerDetails() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Sneaker Brand
        Text(
            text = "NIKE",
            style = CustomType.titleMedium,
        )

        // Sneaker Model
        Text(
            text = "LDV WAFFLE",
            style = CustomType.titleLarge,
            modifier = Modifier.padding(vertical = 35.dp)
        )

        // Sneaker Price
        Text(
            text = "$160.00",
            style = CustomType.titleMedium,
            modifier = Modifier.padding(vertical = 35.dp)
        )
    }
}