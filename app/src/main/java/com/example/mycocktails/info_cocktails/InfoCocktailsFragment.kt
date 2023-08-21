package com.example.mycocktails.info_cocktails

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.mycocktails.Contants.NAME_ID
import com.example.mycocktails.Contants.TAG
import com.example.mycocktails.R
import com.example.mycocktails.databinding.FragmentInfoCocktailsBinding
import com.example.mycocktails.databinding.FragmentListCocktailsBinding
import com.example.mycocktails.presintation.ViewModel
import dagger.hilt.android.AndroidEntryPoint


class InfoCocktailsFragment : Fragment() {

    private var _binding: FragmentInfoCocktailsBinding? = null
    private val binding get() = _binding!!
    private val vm: ViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInfoCocktailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = arguments?.getString(NAME_ID)

        Log.d(TAG, "nameId $name")

        if (name != null) {
            vm.getName(name)
        }

        vm.infoCocktails.observe(viewLifecycleOwner) { it ->
            Log.d(TAG, "$it")
        }
    }
}