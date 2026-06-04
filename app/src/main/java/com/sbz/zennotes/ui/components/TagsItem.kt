package com.sbz.zennotes.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sbz.zennotes.ui.theme.primaryGreen

@Composable
fun TagItem(
    modifier: Modifier = Modifier,
    tag: String,
    backgroundColor: Color,
    onClick: (Unit) -> Unit
) {

    Row(
        modifier = modifier
            .padding(horizontal = 4.dp)
            .clip(RoundedCornerShape(50))
            .background(backgroundColor)
            .padding(
                horizontal = 8.dp,
                vertical = 4.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = tag,
            color = Color.Black,
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(
            modifier = Modifier.width(4.dp)
        )

        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = "Remove Tag",
            modifier = Modifier.size(16.dp)
        )

    }

}


@Preview()
@Composable
private fun TagItemPreview() {
    TagItem(
        tag = "Product",
        backgroundColor = primaryGreen,
        onClick = {

        }
    )
}