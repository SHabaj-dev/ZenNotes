package com.sbz.zennotes.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sbz.zennotes.ui.theme.primaryGreen

@Composable
fun PagerIndicator(
    pageCount: Int,
    currentPage: Int
) {

    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        repeat(pageCount) { index ->

            Box(
                modifier = Modifier
                    .height(8.dp)
                    .width(
                        if (currentPage == index)
                            24.dp
                        else
                            8.dp
                    )
                    .clip(RoundedCornerShape(50))
                    .background(
                        if (currentPage == index)
                            primaryGreen
                        else
                            Color.LightGray
                    )
            )

        }

    }

}

@Preview
@Composable
private fun PagerIndicatorPreview() {
    PagerIndicator(3, 2)
}