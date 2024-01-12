import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ColorCarousel(
    icons: List<Int>,
    selectedColor: Int,
    onSelectColor: (Int) -> Unit
) {
    val colorways = listOf(
        "Pink/Green/Yellow",
        "Green/Red/Black",
        "White"
    )
    // Use a Row if you want to avoid horizontal scrolling
    Row(
        modifier = Modifier
            .padding(16.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        icons.forEachIndexed { index, iconResId ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .clickable { onSelectColor(index) }
            ) {
                Image(
                    painter = painterResource(id = iconResId),
                    contentDescription = colorways[index],
                    modifier = Modifier
                        .size(40.dp) // Adjust the size to match the design
                        .alpha(if (index == selectedColor) 1f else 0.6f) // Non-selected items are more transparent
                )
                // Optional: Add text labels under icons
                Text(
                    text = colorways[index],
                    fontSize = 12.sp,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}