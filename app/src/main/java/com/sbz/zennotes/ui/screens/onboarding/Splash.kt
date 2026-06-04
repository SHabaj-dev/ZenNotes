package com.sbz.zennotes.ui.screens.onboarding

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sbz.zennotes.R
import com.sbz.zennotes.data.datastore.DataStoreManager
import com.sbz.zennotes.ui.components.CustomText
import com.sbz.zennotes.ui.theme.primaryGreen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {

    var startAnimation by remember {
        mutableStateOf(false)
    }

    val progress by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 2000
        ),
        label = "progress"
    )

    val context = LocalContext.current
    val dataStoreManager = remember {
        DataStoreManager(context)
    }

    val isFirstTimeUser by
    dataStoreManager
        .isFirstTimeUser
        .collectAsState(
            initial = true
        )

    LaunchedEffect(Unit) {

        startAnimation = true

        delay(2000)

        if (isFirstTimeUser) {
            navController.navigate("onboarding") {

                popUpTo("splash") {
                    inclusive = true
                }

            }
        } else {
            navController.navigate("main_screen") {

                popUpTo("splash") {
                    inclusive = true
                }

            }
        }




    }


    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = Modifier
                .wrapContentSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .wrapContentSize(),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 12.dp
                )
            ) {

                Image(
                    modifier = Modifier.padding(14.dp),
                    painter = painterResource(R.drawable.ic_pen),
                    contentDescription = "Application Logo"
                )

            }

            CustomText(
                text = "ZenNotes",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            CustomText(
                text = "Capture thoughts in their most\n" +
                        "natural state.",
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center
            )


            Spacer(modifier = Modifier.height(12.dp))

            LinearProgressIndicator(
                progress = { progress },
                modifier = Modifier
                    .padding(16.dp),
                trackColor = Color.LightGray,
                color = primaryGreen
            )


        }

    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SplashScreenPreview() {
    SplashScreen(
        modifier = Modifier.fillMaxSize(),
        navController = rememberNavController()
    )
}