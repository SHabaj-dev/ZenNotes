package com.sbz.zennotes.ui.screens.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sbz.zennotes.R
import com.sbz.zennotes.data.datastore.DataStoreManager
import com.sbz.zennotes.data.model.OnboardingPage
import com.sbz.zennotes.ui.components.CustomText
import com.sbz.zennotes.ui.components.OnboardingButton
import com.sbz.zennotes.ui.components.OnboardingPagerItem
import com.sbz.zennotes.ui.components.PagerIndicator
import com.sbz.zennotes.ui.theme.lightGreen
import com.sbz.zennotes.ui.theme.primaryGreen
import kotlinx.coroutines.launch

@Composable
fun Onboarding(
    modifier: Modifier = Modifier,
    navController: NavController
) {

    val context = LocalContext.current

    val dataStore = remember {
        DataStoreManager(context)
    }

    val pages = listOf(
        OnboardingPage(
            image = R.drawable.pager_1,
            title = "Capture You Thoughts",
            description = "Simple, beautiful, and distraction-free\n" +
                    "note-taking."
        ),
        OnboardingPage(
            image = R.drawable.pager_2,
            title = "Organize Your Life.",
            description = "Use tags and folders to keep your\n" +
                    "thoughts perfectly categorized."
        ),
        OnboardingPage(
            image = R.drawable.pager_3,
            title = "Focus on What Matters.",
            description = "A distraction-free environment\n" +
                    "designed for your best thinking."
        )
    )

    val pagerState = rememberPagerState(
        pageCount = { pages.size }
    )

    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.White,
                        Color.White,
                        lightGreen,
                        Color.White
                    )
                )
            ),
    ) {

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomText(
                text = "ZenNotes",
                style = MaterialTheme.typography.headlineLarge,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = primaryGreen
            )

            HorizontalPager(
                modifier = Modifier.weight(1f),
                state = pagerState,
                userScrollEnabled = false
            ) { page ->
                OnboardingPagerItem(
                    page = pages[page]
                )
            }

            PagerIndicator(
                pageCount = pages.size,
                currentPage = pagerState.currentPage
            )

            Spacer(
                modifier = Modifier.padding(28.dp)
            )

            if (pagerState.currentPage == pages.lastIndex) {

                OnboardingButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Get Started",
                    showArrow = false,
                    onClick = {
                        coroutineScope.launch {
                            dataStore.setFirstTimeUserCompleted()
                            navController.navigate("main_screen")
                        }
                    }
                )

            } else {

                OnboardingButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Next",
                    showArrow = true,
                    onClick = {

                        coroutineScope.launch {

                            pagerState.animateScrollToPage(
                                pagerState.currentPage + 1
                            )

                        }

                    }
                )

                OnboardingButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Skip",
                    showArrow = false,
                    onClick = {
                        coroutineScope.launch {
                            dataStore.setFirstTimeUserCompleted()
                            navController.navigate("main_screen")
                        }
                    },
                    isOutlined = true
                )

            }

        }


    }

}

@Preview
@Composable
private fun OnboardingPreview() {

    Onboarding(navController = rememberNavController())

}

