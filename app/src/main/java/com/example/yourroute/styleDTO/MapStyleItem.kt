package com.example.yourroute.styleDTO

data class MapStyleItem(
    val elements: List<String>,
    val stylers: Stylers,
    val tags: Tags,
    val types: List<String>
)