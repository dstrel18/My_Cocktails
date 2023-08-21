package com.example.mycocktails.screen_cocktails

import android.os.Bundle
import android.provider.SyncStateContract
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.mycocktails.Contants
import com.example.mycocktails.Contants.TAG
import com.example.mycocktails.R
import com.example.mycocktails.data.entities.MyCocktails
import com.example.mycocktails.databinding.FragmentListCocktailsBinding
import com.example.mycocktails.model.AdapterCocktails
import com.example.mycocktails.presintation.ViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListCocktailsFragment : Fragment() {

    private var _binding: FragmentListCocktailsBinding? = null
    private val binding get() = _binding!!
    private val vm: ViewModel by activityViewModels()
    private val adapter = AdapterCocktails { item -> onClick(item) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListCocktailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.cocktails.observe(viewLifecycleOwner) {
            binding.imageList.adapter = adapter
            adapter.setData(it)
        }

        binding.addBv.setOnClickListener {
            findNavController().navigate(R.id.action_listCocktailsFragment_to_creatingCocktailFragment)
        }

        binding.delete.setOnClickListener {
            Log.d(TAG, "Delete")
            vm.cocktails
            vm.delete()
        }
    }

    private fun onClick(cocktails: MyCocktails) {
        val id = cocktails.name
        val bundle = Bundle()
        bundle.putString(Contants.NAME_ID, id)
        findNavController().navigate(
            R.id.action_listCocktailsFragment_to_infoCocktailsFragment, bundle
        )
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}