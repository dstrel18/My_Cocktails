package com.example.mycocktails.presintation

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.mycocktails.R
import com.example.mycocktails.databinding.FragmentStartScreenBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StartScreenFragment : Fragment() {

    private var _binding: FragmentStartScreenBinding? = null
    private val binding get() = _binding!!
    private val vm: ViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStartScreenBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler(Looper.getMainLooper()).postDelayed({
            vm.cocktails.observe(viewLifecycleOwner) {
                if (it.isEmpty()) {
                    findNavController().navigate(R.id.action_startScreenFragment_to_addCocktailsFragment)
                } else {
                    findNavController().navigate(R.id.action_startScreenFragment_to_listCocktailsFragment)
                }
            }

        }, 700)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}