package com.example.mycocktails.editing_screen

import android.os.Bundle
import android.os.ParcelFileDescriptor
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.mycocktails.R
import com.example.mycocktails.databinding.FragmentCreatingCocktailBinding
import com.example.mycocktails.databinding.FragmentStartScreenBinding
import com.example.mycocktails.presintation.ViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreatingCocktailFragment : Fragment() {

    private var _binding: FragmentCreatingCocktailBinding? = null
    private val binding get() = _binding!!
    private val vm: ViewModel by activityViewModels()
    private lateinit var name: String

    //    private var image: String? = null!!
    private lateinit var descriptor: String
    private lateinit var recipe: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreatingCocktailBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        name = binding.titleET.text.toString()
        val image = null
        descriptor = binding.descriptionET.toString()
        recipe = binding.recipeET.toString()

        binding.save.setOnClickListener {
            vm.insertDatabase(name, image, descriptor, recipe)
            findNavController().navigate(R.id.action_creatingCocktailFragment_to_listCocktailsFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}