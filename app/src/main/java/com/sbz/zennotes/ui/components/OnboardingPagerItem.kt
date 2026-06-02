package com.sbz.zennotes.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sbz.zennotes.R
import com.sbz.zennotes.data.model.OnboardingPage

@Composable
fun OnboardingPagerItem(page: OnboardingPage) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .padding(26.dp)
                .clip(
                    RoundedCornerShape(10.dp)
                ),
            painter = painterResource(page.image),
            contentDescription = page.description,
            contentScale = ContentScale.FillBounds
        )

        Spacer(modifier = Modifier.padding(2.dp))

        CustomText(
            text = page.title,
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
        )



        CustomText(
            text = page.description,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            color = Color.Gray,
            fontWeight = FontWeight.Normal,
        )


    }

}

@Preview(showBackground = true)
@Composable
private fun OnboardingItemPreview() {
    OnboardingPagerItem(
        OnboardingPage(
            image = R.drawable.ic_launcher_background,
            title = "This is the Title",
            description = "This is the Descriptions"
        )
    )
}