package com.example.breezsneaker.ui.composables

import CustomType
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.breezsneaker.R

@Composable
fun SneakerDescription(){
    Column(){
        // Size Guide
        Text(
            text = stringResource(id = R.string.size_guide),
            style = CustomType.bodyMedium.copy(textDecoration = TextDecoration.Underline),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 202.dp, bottom = 92.dp)
        )

        // Description Text
        Text(
            text = stringResource(id = R.string.shoe_description),
            style = CustomType.bodyMedium,
            modifier = Modifier
                .height(326.dp)
                .padding(start = 202.dp, end = 202.dp)
        )
    }
}

@Preview
@Composable
fun SneakerDescriptionPreview(){
    SneakerDescription()
}