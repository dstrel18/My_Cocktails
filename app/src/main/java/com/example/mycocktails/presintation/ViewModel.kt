package com.example.mycocktails.presintation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.mycocktails.Repository.Repository
import com.example.mycocktails.data.entities.NewCocktails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {


    val cocktails: LiveData<List<NewCocktails>> = this.repository.getAllRoom().asLiveData()


    fun insertDatabase(name: String, image: String?, description: String, recipe: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(
               NewCocktails(
                    name = name,
                    image = image,
                    description = description,
                    recipe = recipe
                )
            )
        }
    }
}