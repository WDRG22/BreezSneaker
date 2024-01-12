package com.example.breezsneaker.ui.composables

import CustomType
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.breezsneaker.R

@Composable
fun Footer(){
    Box() {
        Row(
            modifier = Modifier
                .padding(bottom = 12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.breez_logo_black),
                contentDescription = null, // decorative
                modifier = Modifier
                    .height(64.dp)
            )
            Spacer(modifier = Modifier.width(25.dp))
            Text(
                text = stringResource(id = R.string.powered_by_cyntra_ai),
                style = CustomType.bodySmall,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.width(18.dp))
            Image(
                painter = painterResource(id = R.drawable.footer_icon),
                contentDescription = null, // decorative
                modifier = Modifier.size(64.dp)
            )
        }
    }
}