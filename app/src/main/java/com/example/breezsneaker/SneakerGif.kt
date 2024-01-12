import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.breezsneaker.R

@Composable
fun SneakerGif(drawableResId: Int) {
    AsyncImage(
        model = drawableResId,
        contentDescription = "Sneaker",
        modifier = Modifier
            // Add sizing or other modifiers as appropriate
            .padding(vertical = 8.dp)
            .size(240.dp)
            .background(light_grey)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Box(modifier = Modifier.background(Color.Gray), contentAlignment = Alignment.Center) {
        // Replace R.drawable.shoe_gif with your actual drawable resource ID
        SneakerGif(drawableResId = R.drawable.shoe_green)
    }
}