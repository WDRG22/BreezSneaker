import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.breezsneaker.R
import com.example.breezsneaker.ui.theme.grey

val Aldrich = FontFamily(Font(R.font.aldrich))
val Inter = FontFamily(Font(R.font.inter))
val SulphurPoint = FontFamily(Font(R.font.sulphur_point))

val CustomType = Typography(
    titleLarge = TextStyle(
        fontFamily = Aldrich,
        fontWeight = FontWeight.Bold,
        fontSize = 94.sp,
        color = Color.Black
    ),
    titleMedium = TextStyle(
        fontFamily = Aldrich,
        fontWeight = FontWeight.Bold,
        fontSize = 64.sp,
        color = Color.Black
    ),
    titleSmall = TextStyle(
        fontFamily = Aldrich,
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp,
        color = Color.Black
    ),
    bodyMedium = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Normal,
        fontSize = 58.sp,
        color = grey
    ),
    bodySmall = TextStyle(
        fontFamily = SulphurPoint,
        fontWeight = FontWeight.Normal,
        fontSize = 35.sp,
        color = Color.Black
    )
)
