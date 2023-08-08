package com.example.mycocktails.Repository

import com.example.mycocktails.data.CocktailsDao
import com.example.mycocktails.data.entities.NewCocktails
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class Repository @Inject constructor(
    private val cocktailDAO: CocktailsDao
) {
    fun getAllRoom(): Flow<List<NewCocktails>> {
        return cocktailDAO.getAll()
    }

    suspend fun insert(cocktail: NewCocktails) {
        cocktailDAO.insert(cocktail)
    }

}