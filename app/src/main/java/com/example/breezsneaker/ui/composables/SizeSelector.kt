package com.example.breezsneaker.ui.composables

import CustomType
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.breezsneaker.ui.theme.light_grey

@Composable
fun ShoeSizeSelector() {
    val shoeSizes = listOf("39", "40", "41", "42", "43", "44", "45", "46")
    var selectedSize by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .padding(horizontal = 202.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "Men's Size",
            style = CustomType.bodyMedium,
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 200.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            shoeSizes.forEach { size ->
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .border(
                            width = 8.dp,
                            color = if (size == selectedSize) Color.Black else light_grey,
                        )
                        .clickable { selectedSize = size }
                        .size(height = 160.dp, width = 173.dp)
                ) {
                    Text(
                        text = size,
                        style = CustomType.titleSmall,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ShoeSizeSelectorPreview() {
    ShoeSizeSelector()
}
