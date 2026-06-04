package com.sbz.zennotes.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sbz.zennotes.data.model.Note
import com.sbz.zennotes.ui.components.CustomSearchBar
import com.sbz.zennotes.ui.components.CustomText
import com.sbz.zennotes.ui.components.NotesItem
import com.sbz.zennotes.ui.theme.primaryGreen

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {

    val notesList = listOf(
        Note(
            id = 1,
            category = listOf(
                "Production",
                "Learning"
            ),
            date = "Jan 26, 2026",
            title = "Notes Title 1",
            descriptions = "Notes Description 1"
        ),
        Note(
            id = 2,
            category = listOf(
                "Production",
                "Learning"
            ),
            date = "Jan 26, 2026",
            title = "Notes Title 2",
            descriptions = "Notes Description 2"
        ),
        Note(
            id = 3,
            category = listOf(
                "Production",
                "Learning"
            ),
            date = "Jan 26, 2026",
            title = "Notes Title 3",
            descriptions = "Notes Description 3"
        )
    )

    var searchQuery by remember {
        mutableStateOf("")
    }

    Column(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        CustomText(
            text = "ZenNotes",
            textAlign = TextAlign.Start,
            modifier = Modifier.fillMaxWidth(),
            color = primaryGreen,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(10.dp))

        CustomSearchBar(
            query = searchQuery,
            onQueryChange = {
                searchQuery = it
            }
        )

        LazyColumn(
            modifier = Modifier
                .padding(vertical = 10.dp)
                .weight(1f)
        ) {

            items(notesList) { item ->
                NotesItem(
                    modifier = Modifier
                        .padding(vertical = 4.dp),
                    note = item
                )
            }

        }


    }


}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen(
        modifier = Modifier,
        navController = rememberNavController()
    )
}