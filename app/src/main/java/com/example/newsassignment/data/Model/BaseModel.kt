package com.example.newsassignment

data class BaseModel<T>(
    val status: String?,
    val message: String?,
    val articles: T
)
