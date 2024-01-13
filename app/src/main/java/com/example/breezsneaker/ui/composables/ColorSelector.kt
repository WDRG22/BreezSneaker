package com.example.breezsneaker.ui.composables

import CustomType
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.breezsneaker.R
import kotlinx.coroutines.launch

@Composable
fun ColorSelector(onSelectColor: (Int) -> Unit ) {
    var selectedColor by remember { mutableIntStateOf(0) }
    val sneakerIcons = listOf(
        R.drawable.shoe_pink_icon,
        R.drawable.shoe_green_icon,
        R.drawable.shoe_white_icon
    )
    val colorways = listOf(
        "Pink/Green/Yellow",
        "Green/Red/Black",
        "White"
    )
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(selectedColor) {
        coroutineScope.launch {
            listState.animateScrollToItem(index = selectedColor)
        }
    }

    LazyRow(
        state = listState,
        horizontalArrangement = Arrangement.Center,
    ) {
        items(sneakerIcons.size) { index ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .clickable {
                        onSelectColor(index)
                    }
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(350.dp)
                        .border(
                            width = if (index == selectedColor) 8.dp else 0.dp,
                            color = if (index == selectedColor) Color.Black else Color.Transparent,
                        )
                ) {
                    Image(
                        painter = painterResource(id = sneakerIcons[index]),
                        contentDescription = colorways[index],
                        modifier = Modifier
                            .size(500.dp)
                            .alpha(if (index == selectedColor) 1f else 0.6f)
                    )
                }
                // Show text label only for the selected icon
                if (index == selectedColor) {
                    Text(
                        text = colorways[index],
                        style = CustomType.bodyMedium,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ColorCarouselPreview() {
    ColorSelector { newColorIndex ->
        println("Selected color index: $newColorIndex")
    }
}