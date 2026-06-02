package com.sbz.zennotes.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sbz.zennotes.data.model.Note

@Composable
fun NotesItem(
    modifier: Modifier = Modifier,
    note: Note
) {

    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {

        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                LazyRow(
                    modifier = Modifier
                        .weight(1f)
                        .clip(shape = RoundedCornerShape(12.dp)),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(note.category) { category ->

                        Card(
                            shape = RoundedCornerShape(50.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFFE8F5E9)
                            )
                        ) {

                            CustomText(
                                text = category,
                                modifier = Modifier.padding(
                                    horizontal = 12.dp,
                                    vertical = 6.dp
                                ),
                                style = MaterialTheme.typography.bodySmall,
                                textAlign = TextAlign.Center
                            )

                        }

                    }
                }

                CustomText(
                    text = note.date,
                    modifier = Modifier.padding(
                        horizontal = 12.dp,
                        vertical = 6.dp
                    ),
                    style = MaterialTheme.typography.bodySmall,
                    textAlign = TextAlign.Center
                )

            }

            Text(
                text = note.title,
                modifier = Modifier
                    .padding(start = 12.dp, end = 12.dp, top = 12.dp, bottom = 4.dp)
                    .fillMaxWidth(),
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )


            Text(
                text = note.descriptions,
                modifier = Modifier
                    .padding(start = 12.dp, end = 12.dp, bottom = 12.dp, top = 4.dp)
                    .fillMaxWidth(),
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Normal,
                maxLines = 4,
                overflow = TextOverflow.Ellipsis
            )


        }

    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun NotesItemPreview() {
    NotesItem(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 26.dp),
        Note(
            1,
            listOf(
                "Product"
            ),
            "Jun 6, 2026",
            "This is My Notes",
            "This is a sample Description for the given Notes and can go up to more than 4 lines that is why im wrting this text so long"
        )
    )
}