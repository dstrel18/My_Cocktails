package com.example.mycocktails.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mycocktails.data.entities.NewCocktails
import com.example.mycocktails.databinding.MyItemListCocktailsBinding

class AdapterCocktails(
    private val data: List<NewCocktails>,
) :
    RecyclerView.Adapter<AdapterCocktails.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MyItemListCocktailsBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val cocktails = data[position]
        holder.binding.nameCocktail.text = cocktails.name
    }

    override fun getItemCount(): Int = data.size

    inner class ViewHolder(val binding: MyItemListCocktailsBinding) :
        RecyclerView.ViewHolder(binding.root)
}
