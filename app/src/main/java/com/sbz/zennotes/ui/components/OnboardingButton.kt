package com.sbz.zennotes.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sbz.zennotes.ui.theme.lightGreen
import com.sbz.zennotes.ui.theme.primaryGreen

@Composable
fun OnboardingButton(
    text: String,
    modifier: Modifier = Modifier,
    showArrow: Boolean = false,
    isOutlined: Boolean = false,
    backgroundColor: Color = primaryGreen,
    contentColor: Color = Color.White,
    onClick: () -> Unit
) {

    if (isOutlined) {

        OutlinedButton(
            modifier = modifier,
            onClick = onClick,
            border = BorderStroke(
                width = 1.dp,
                color = lightGreen
            )
        ) {

            Text(text)

            if (showArrow) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = null
                )
            }
        }

    } else {

        Button(
            modifier = modifier,
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = backgroundColor,
                contentColor = contentColor
            )
        ) {

            Text(text)

            if (showArrow) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = null
                )
            }
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun OnboardingButtonPreview() {
    OnboardingButton(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        text = "Next",
        showArrow = true,
        onClick = {},
        isOutlined = true
    )
}