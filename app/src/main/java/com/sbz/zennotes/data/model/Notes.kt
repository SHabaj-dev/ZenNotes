package com.sbz.zennotes.data.model

data class Note(
    val id: Int,
    val category: List<String>,
    val date: String,
    val title: String,
    val descriptions: String
)