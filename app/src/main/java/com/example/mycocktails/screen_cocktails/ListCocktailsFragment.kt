package com.example.mycocktails.screen_cocktails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mycocktails.R
import com.example.mycocktails.databinding.FragmentAddCocktaillBinding
import com.example.mycocktails.databinding.FragmentListCocktailsBinding
import com.example.mycocktails.model.AdapterCocktails
import com.example.mycocktails.presintation.ViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListCocktailsFragment : Fragment() {

    private var _binding: FragmentListCocktailsBinding? = null
    private val binding get() = _binding!!
    private val vm: ViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListCocktailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.cocktails.observe(viewLifecycleOwner) {
            val adapter = AdapterCocktails(it)
            binding.imageList.adapter = adapter
        }

        binding.addBv.setOnClickListener {
            findNavController().navigate(R.id.action_listCocktailsFragment_to_creatingCocktailFragment)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}