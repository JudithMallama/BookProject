package com.example.bookproject.model

import java.io.Serializable

data class Book(
    val name: String,
    val author: String,
    val pages: Int,
    val abstract: String,
    val genere: String,
    val score: Int,
    val publicationDate: String
) : Serializable
