package com.bizmiz.milliyoyinlar.fragments.oyinlar

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowInsetsController
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import com.bizmiz.milliyoyinlar.R
import com.bizmiz.milliyoyinlar.databinding.FragmentAsosiyBinding
import com.bizmiz.milliyoyinlar.databinding.FragmentOyinlarBinding
import com.gita.allomalar.adapter.ItemAdapter

class OyinlarFragment : Fragment() {
    private lateinit var itemAdapter:ItemAdapter
    private lateinit var binding: FragmentOyinlarBinding
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
        binding = FragmentOyinlarBinding.bind(inflater.inflate(R.layout.fragment_oyinlar, container, false))
        itemAdapter = ItemAdapter()
        binding.recView.adapter = itemAdapter
        itemAdapter.setOnclickListener { position ->
            val bundle = bundleOf(
                "position" to position+1
            )
            val navController = Navigation.findNavController(requireActivity(),R.id.fragmentContainer)
            navController.navigate(R.id.action_oyinlarFragment_to_openTextFragment,bundle)
        }
        return binding.root
    }
}