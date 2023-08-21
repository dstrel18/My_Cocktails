package com.example.mycocktails.presintation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.mycocktails.Contants
import com.example.mycocktails.Repository.Repository
import com.example.mycocktails.data.entities.MyCocktails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {


    val cocktails: LiveData<List<MyCocktails>> = this.repository.getAllRoom().asLiveData()

    private val _infoCocktails: MutableLiveData<List<MyCocktails>> = MutableLiveData()
    val infoCocktails: LiveData<List<MyCocktails>> get() = _infoCocktails

    fun insertDatabase(name: String, image: String?, description: String, recipe: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(
                MyCocktails(
                    name = name, image = image, description = description, recipe = recipe
                )
            )
        }
    }

    fun getName(nameId: String) {
        viewModelScope.launch {
            val list = repository.getCocktailsByName(nameId)
            _infoCocktails.value = list
        }
    }

    fun delete() {
        viewModelScope.launch {
            cocktails.value?.lastOrNull()?.let { repository.delete(it) }
            Log.d("tag", "weatherD - ${cocktails.value}")
        }
    }
}