import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.util.VelocityTracker
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.zIndex
import kotlinx.coroutines.coroutineScope
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Stable
interface CircularCarouselState {
    val angle: Float
    suspend fun snapTo(angle: Float)
}

class CircularCarouselStateImpl : CircularCarouselState {
    private val _angle = Animatable(0f)
    override val angle: Float
        get() = _angle.value
    override suspend fun snapTo(angle: Float) {
        _angle.snapTo(angle)
    }
}

@Composable
fun rememberCircularCarouselState(): CircularCarouselState = remember {
    CircularCarouselStateImpl()
}

@Composable
fun CircularCarousel(
    shoeIcons: List<Int>,
    modifier: Modifier = Modifier,
    itemFraction: Float = .25f,
    state: CircularCarouselState = rememberCircularCarouselState(),
    onSelectIcon: (Int) -> Unit,
) {
    val numItems = shoeIcons.size
    require(numItems > 0) { "There must be at least one item" }
    val angleStep = 360f / numItems

    Layout(
        modifier = modifier
            .pointerInput(Unit) {
                coroutineScope {
                    while (true) {
                        val pointerInputChange = awaitPointerEventScope { awaitFirstDown() }
                        val tracker = VelocityTracker()
                        val degreesPerPixel = 360f / size.width.toFloat()

                        drag(pointerInputChange.id) { change ->
                            val horizontalDragAmount: Float = change.positionChange().x * degreesPerPixel
                            val newAngle: Float = state.angle + horizontalDragAmount
                            state.snapTo(newAngle)

                            tracker.addPosition(change.uptimeMillis, change.position)
                            if (change.positionChange() != Offset.Zero) {
                                change.consume()
                            }
                        }
                    }
                }
            },
        content = {
            shoeIcons.forEachIndexed { index, iconResId ->
                val itemAngle = (state.angle + angleStep * index).rem(360f)
                Box(
                    modifier = Modifier
                        .zIndex(if (itemAngle <= 180f) 180f - itemAngle else itemAngle - 180f)
                        .graphicsLayer {
                            rotationY = itemAngle
                        }
                        .pointerInput(iconResId) {
                            detectTapGestures {
                                onSelectIcon(index)
                                val targetAngle = -index * angleStep
                                state.snapTo(targetAngle)
                            }
                        }
                ) {
                    Image(
                        painter = painterResource(id = iconResId),
                        contentDescription = "Shoe Icon $index"
                    )
                }
            }
        }
    ) { measurables, constraints ->
        val itemDimension = constraints.maxHeight * itemFraction
        val itemConstraints = Constraints.fixed(
            width = itemDimension.toInt(),
            height = itemDimension.toInt()
        )
        val placeables = measurables.map { measurable -> measurable.measure(itemConstraints) }

        layout(constraints.maxWidth, constraints.maxHeight) {
            val centerX = constraints.maxWidth / 2
            val centerY = constraints.maxHeight / 2
            val radius = (constraints.maxWidth - itemDimension) / 2

            placeables.forEachIndexed { index, placeable ->
                val itemAngle = (state.angle.toDouble() + angleStep * index).rem(360.0) * (PI / 180)
                val x = (centerX + radius * cos(itemAngle) - itemDimension / 2).toInt()
                val y = (centerY + radius * sin(itemAngle) - itemDimension / 2).toInt()

                placeable.placeRelative(x, y)
            }
        }
    }
}
