package com.example.mycocktails.screen_cocktails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.mycocktails.R
import com.example.mycocktails.databinding.FragmentAddCocktaillBinding
import com.example.mycocktails.databinding.FragmentStartScreenBinding
import com.example.mycocktails.presintation.ViewModel

class AddCocktailsFragment : Fragment() {

    private var _binding: FragmentAddCocktaillBinding? = null
    private val binding get() = _binding!!
    private val vm: ViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddCocktaillBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addCocktailBV.setOnClickListener {
            findNavController().navigate(R.id.action_addCocktailsFragment_to_creatingCocktailFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}