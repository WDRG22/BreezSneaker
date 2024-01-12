import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.breezsneaker.R
import com.example.breezsneaker.ui.composables.ColorSelector
import com.example.breezsneaker.ui.composables.Footer
import com.example.breezsneaker.ui.composables.ShoeSizeSelector
import com.example.breezsneaker.ui.composables.SneakerDescription
import com.example.breezsneaker.ui.composables.SneakerDetails
import com.example.breezsneaker.ui.composables.SneakerGif
import com.example.breezsneaker.ui.composables.TopBar
import com.example.breezsneaker.ui.composables.TryNowButton

@Composable
fun MainScreen() {
    // Maintain state for the selected color index
    var selectedColorIndex by remember { mutableStateOf(0) }

    // Define the sneaker GIFs corresponding to each color
    val sneakerGifs = listOf(
        R.drawable.shoe_pink, // Replace with actual GIF resource IDs
        R.drawable.shoe_green,
        R.drawable.shoe_white
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        TopBar()
        SneakerGif(sneakerGifs[selectedColorIndex])
        Spacer(modifier = Modifier.height(71.dp))
        SneakerDetails()
        Spacer(modifier = Modifier.height(95.dp))
        ColorSelector{ newColorIndex -> selectedColorIndex = newColorIndex }
        Spacer(modifier = Modifier.height(91.dp))
        ShoeSizeSelector()
        Spacer(modifier = Modifier.height(91.dp))
        SneakerDescription()
        Spacer(modifier = Modifier.height(91.dp))
        TryNowButton()
        Spacer(modifier = Modifier.height(91.dp))
        Footer()
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}
