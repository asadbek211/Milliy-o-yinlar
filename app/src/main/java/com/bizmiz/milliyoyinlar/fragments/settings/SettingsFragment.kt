package com.bizmiz.milliyoyinlar.fragments.settings

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowInsetsController
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.bizmiz.milliyoyinlar.MainActivity
import com.bizmiz.milliyoyinlar.R
import com.bizmiz.milliyoyinlar.databinding.FragmentSettingsBinding
import com.orhanobut.hawk.Hawk

class SettingsFragment : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentSettingsBinding
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
        binding = FragmentSettingsBinding.bind(inflater.inflate(R.layout.fragment_settings, container, false))
        binding.uzbek.setOnClickListener(this)
        binding.english.setOnClickListener(this)
        binding.russian.setOnClickListener(this)
        binding.qoraqalpoq.setOnClickListener(this)

        return binding.root
    }
    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.uzbek -> {
                setLanguage("uz")
            }
            R.id.english -> {
                setLanguage("en")
            }
            R.id.russian -> {
                setLanguage("ru")
            }
            R.id.qoraqalpoq -> {
                setLanguage("qr")
            }
        }
    }
    private fun setLanguage(id: String) {
        Hawk.put("pref_lang", id)
        requireActivity().finish()
        requireActivity().startActivity(Intent(requireActivity(), MainActivity::class.java))
    }
}