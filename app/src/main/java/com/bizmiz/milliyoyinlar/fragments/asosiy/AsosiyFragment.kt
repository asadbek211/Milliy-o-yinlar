package com.bizmiz.milliyoyinlar.fragments.asosiy

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowInsetsController
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import com.bizmiz.milliyoyinlar.R
import com.bizmiz.milliyoyinlar.databinding.FragmentAsosiyBinding

class AsosiyFragment : Fragment() {
    private lateinit var binding: FragmentAsosiyBinding
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        requireActivity().window.statusBarColor = ContextCompat.getColor(requireActivity(),R.color.background)
        requireActivity().window.decorView.windowInsetsController?.setSystemBarsAppearance(
            0,
            WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
        )
       binding = FragmentAsosiyBinding.bind(inflater.inflate(R.layout.fragment_asosiy, container, false))
        binding.nextBtn.setOnClickListener {
     val navController = Navigation.findNavController(requireActivity(),R.id.fragmentContainer)
           navController.navigate(R.id.action_asosiyFragment_to_oyinlarFragment)
        }
        binding.settingsBtn.setOnClickListener {
            val navController = Navigation.findNavController(requireActivity(),R.id.fragmentContainer)
            navController.navigate(R.id.action_asosiyFragment_to_settingsFragment)
        }
        return binding.root
    }
}