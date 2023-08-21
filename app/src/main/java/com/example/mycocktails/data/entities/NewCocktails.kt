package com.example.mycocktails.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "myCocktails")
data class MyCocktails(
    @PrimaryKey() @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "image") val image: String? = null,
    @ColumnInfo(name = "description") val description: String? = null,
    @ColumnInfo(name = "recipe") val recipe: String? = null,
    @ColumnInfo(name = "ingredient") val ingredient: String? = null
)
