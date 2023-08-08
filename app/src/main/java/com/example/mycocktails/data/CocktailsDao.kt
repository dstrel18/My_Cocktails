package com.example.mycocktails.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mycocktails.data.entities.NewCocktails
import kotlinx.coroutines.flow.Flow

@Dao
interface CocktailsDao {


    @Query("SELECT * FROM newCocktails ")
    fun getAll(): Flow<List<NewCocktails>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cocktails: NewCocktails)
//
//    @Query("")
//    suspend fun update(word: String)

    @Delete
    suspend fun allDelete(word: NewCocktails)
}