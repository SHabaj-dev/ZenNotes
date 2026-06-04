package com.sbz.zennotes.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.automirrored.rounded.Redo
import androidx.compose.material.icons.automirrored.rounded.Undo
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
import com.sbz.zennotes.ui.components.AddTagsButton
import com.sbz.zennotes.ui.components.CustomText
import com.sbz.zennotes.ui.components.TagItem
import com.sbz.zennotes.ui.theme.lightGreen
import com.sbz.zennotes.ui.theme.primaryGreen

@Composable
fun AddEdit(
    modifier: Modifier = Modifier,
    navController: NavController
) {

    var notesTitle by remember {
        mutableStateOf("")
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(
                horizontal = 16.dp,
                vertical = 2.dp
            )
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {

            IconButton(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Icon(

                    imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                    contentDescription = "Back Button"
                )
            }

            Spacer(modifier = Modifier.width(3.dp))

            CustomText(
                text = "ZenNotes",
                textAlign = TextAlign.Start,
                modifier = Modifier.weight(1f),
                color = primaryGreen,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineMedium
            )

            IconButton(
                onClick = {
                    //Todo: Undo Functionality
                }
            ) {
                Icon(

                    imageVector = Icons.AutoMirrored.Rounded.Undo,
                    contentDescription = "Undo"
                )
            }

            IconButton(
                onClick = {
                    //Todo: Redo Functionality
                }
            ) {
                Icon(

                    imageVector = Icons.AutoMirrored.Rounded.Redo,
                    contentDescription = "Redo"
                )
            }

        }

        BasicTextField(
            value = notesTitle,
            onValueChange = {
                notesTitle = it
            },
            textStyle = MaterialTheme.typography.headlineMedium.copy(
                color = MaterialTheme.colorScheme.onBackground
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            decorationBox = { innerTextField ->

                Box {

                    if (notesTitle.isEmpty()) {

                        Text(
                            text = "Title",
                            style = MaterialTheme.typography.headlineMedium,
                            color = MaterialTheme.colorScheme.onBackground.copy(
                                alpha = 0.4f
                            ),
                            fontWeight = FontWeight.Bold
                        )

                    }

                    innerTextField()

                }

            }
        )

        val categoryList = listOf(
            "Product",
            "Car",
            "Bike"
        )

        LazyRow(
            modifier = Modifier.fillMaxWidth()
        ) {

            items(categoryList) { category ->
                TagItem(
                    tag = category,
                    backgroundColor = lightGreen,
                    onClick = {
                        
                    }
                )

            }

            item {
                AddTagsButton(
                    onClick = {

                    }
                )
            }

        }

    }


}

@Preview(showBackground = true)
@Composable
private fun AddEditPreview() {
    AddEdit(
        modifier = Modifier.padding(20.dp),
        navController = rememberNavController()
    )
}