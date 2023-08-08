package com.example.mycocktails.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mycocktails.data.entities.NewCocktails

@Database(entities = [NewCocktails::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getCocktailDao(): CocktailsDao
}

