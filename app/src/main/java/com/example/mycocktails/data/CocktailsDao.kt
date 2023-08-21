package com.example.mycocktails.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mycocktails.data.entities.MyCocktails
import com.example.mycocktails.databinding.FragmentCreateIngredientBinding
import kotlinx.coroutines.flow.Flow

@Dao
interface CocktailsDao {


    @Query("SELECT * FROM myCocktails ")
    fun getAll(): Flow<List<MyCocktails>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cocktails: MyCocktails)

    @Delete
    suspend fun allDelete(cocktail: MyCocktails)

    @Query("SELECT * FROM myCocktails WHERE name = :name")
    suspend fun getCocktailsByName(name: String): List<MyCocktails>
}