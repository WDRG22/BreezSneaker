import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.breezsneaker.R

// Theme Fonts
val Aldrich = FontFamily(Font(R.font.aldrich))
val Inter = FontFamily(Font(R.font.inter))
val SulphurPoint = FontFamily(Font(R.font.sulphur_point))

// Theme Colors
val black = Color(0xFF000000)
val white = Color(0xFFFFFFFF)
val grey = Color(0xFF565656)
val light_grey = Color(0xFFF6F6F6)


@Composable
fun MainScreen() {

    val sneakerIcons = listOf(
        R.drawable.shoe_pink_icon,
        R.drawable.shoe_green_icon,
        R.drawable.shoe_white_icon
    )

    val sneakerGifs = listOf(
        R.drawable.shoe_pink,
        R.drawable.shoe_green,
        R.drawable.shoe_white
    )
    var selectedColor by remember { mutableIntStateOf(0) }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Header with adjusted padding and logo size
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black)
                    .padding(16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.breez_logo_white),
                    contentDescription = "BREEZ Logo",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(120.dp, 60.dp) // Example size, adjust as needed
                )
            }

            // Sneaker gif
            SneakerGif(drawableResId = sneakerGifs[selectedColor])

            // Sneaker Brand
            Text(
                text = "NIKE",
                style = TextStyle(
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 18.sp,
                    color = Color.Black
                ),
                modifier = Modifier.padding(vertical = 8.dp)
            )

            // Sneaker Model
            Text(
                text = "LDV WAFFLE",
                style = TextStyle(
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 24.sp,
                    color = Color.Black
                ),
                modifier = Modifier.padding(vertical = 8.dp)
            )

            // Sneaker Price
            Text(
                text = "$160.00",
                style = TextStyle(
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 18.sp,
                    color = Color.Black
                ),
                modifier = Modifier.padding(bottom = 24.dp)
            )

            // ColorCarousel with label
            ColorCarousel(
                icons = sneakerIcons,
                selectedColor = selectedColor,
                onSelectColor = { index ->
                    selectedColor = index
                }
            )


            // TODO: Add size selector

            // Size Guide
            Text(
                text = stringResource(id = R.string.size_guide),
                style = TextStyle(
                    fontFamily = Inter,
                    fontSize = 48.sp,
                    color = grey
                ),
                modifier = Modifier
                    .padding(horizontal = 210.dp)
            )

            // Description Text
            Text(
                text = stringResource(id = R.string.shoe_description),
                style = TextStyle(
                    fontFamily = Inter,
                    fontSize = 48.sp,
                    color = grey
                ),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(horizontal = 210.dp)
            )

            // Try Now Button
            Button(
                onClick = { /* TODO: handle click */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(185.dp)
                    .padding(horizontal = 210.dp)
            ) {
                Text(text = stringResource(id = R.string.try_now))
            }
        }

        // Footer
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 45.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.breez_logo_black),
                contentDescription = null, // decorative
                modifier = Modifier.size(width = 204.dp, height = 41.dp)
            )
            Spacer(modifier = Modifier.width(25.dp))
            Text(
                text = stringResource(id = R.string.powered_by_cyntra_ai),
                style = TextStyle(
                    fontFamily = SulphurPoint,
                    fontSize = 35.sp,
                    color = grey
                ),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.width(25.dp))
            Image(
                painter = painterResource(id = R.drawable.footer_icon),
                contentDescription = null, // decorative
                modifier = Modifier.size(41.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}
