package com.sbz.zennotes.ui.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AddTagsButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {

    Box(
        modifier = modifier
            .padding(horizontal = 4.dp)
            .wrapContentSize()
            .drawBehind {

                drawRoundRect(
                    color = Color.LightGray,
                    style = Stroke(
                        width = 1.dp.toPx(),
                        pathEffect = PathEffect.dashPathEffect(
                            floatArrayOf(
                                15f,
                                10f
                            )
                        )
                    ),
                    cornerRadius = CornerRadius(
                        100.dp.toPx(),
                        100.dp.toPx()
                    )
                )

            }
            .padding(10.dp, 4.dp)
            .clickable(
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {

        Text(
            text = "+ Add Tags",
            color = Color.Black,
            style = MaterialTheme.typography.bodyMedium
        )

    }

}


@Preview()
@Composable
private fun TagItemPreview() {
    AddTagsButton(
        onClick = {

        }
    )
}