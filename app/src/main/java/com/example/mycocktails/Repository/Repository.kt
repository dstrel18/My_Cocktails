package com.example.mycocktails.Repository

import com.example.mycocktails.data.CocktailsDao
import com.example.mycocktails.data.entities.MyCocktails
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class Repository @Inject constructor(
    private val cocktailDAO: CocktailsDao
) {
    fun getAllRoom(): Flow<List<MyCocktails>> {
        return cocktailDAO.getAll()
    }

   suspend fun getCocktailsByName(name: String): List<MyCocktails> {
        return cocktailDAO.getCocktailsByName(name)
    }

    suspend fun insert(cocktail: MyCocktails) {
        cocktailDAO.insert(cocktail)
    }

    suspend fun delete(cocktail: MyCocktails) {
        cocktailDAO.allDelete(cocktail)
    }

}