package com.example.mycocktails.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mycocktails.data.entities.MyCocktails
import com.example.mycocktails.databinding.MyItemListCocktailsBinding

class AdapterCocktails(
    val onClick: (MyCocktails) -> Unit,
) : RecyclerView.Adapter<AdapterCocktails.ViewHolder>() {

    private var data: List<MyCocktails> = emptyList()

    fun setData(data: List<MyCocktails>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MyItemListCocktailsBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val cocktails = data[position]
        holder.binding.nameCocktail.text = cocktails.name

        holder.binding.root.setOnClickListener {
            cocktails?.let {
                onClick(cocktails)
            }
        }
    }

    override fun getItemCount(): Int = data.size

    inner class ViewHolder(val binding: MyItemListCocktailsBinding) :
        RecyclerView.ViewHolder(binding.root)
}
