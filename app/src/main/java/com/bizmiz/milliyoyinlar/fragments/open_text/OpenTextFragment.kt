package com.bizmiz.milliyoyinlar.fragments.open_text

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowInsetsController
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.bizmiz.milliyoyinlar.R
import com.bizmiz.milliyoyinlar.dao.Dao
import com.bizmiz.milliyoyinlar.databinding.FragmentOpenTextBinding
import com.bizmiz.milliyoyinlar.db.OyinlarDatabase
import com.orhanobut.hawk.Hawk

class OpenTextFragment : Fragment() {
    private lateinit var dao: Dao
    private lateinit var binding: FragmentOpenTextBinding

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val list:ArrayList<String> = arrayListOf(
            getString(R.string.kurash),
            getString(R.string.ot_oyin),
            getString(R.string.dorboz),
            getString(R.string.tosh_kotarish),
            getString(R.string.arqon_tortish),
            getString(R.string.kuch_sinash),
            getString(R.string.harakatli_oyin)
        )
        val argument = requireArguments().getInt("position")
        requireActivity().window.statusBarColor =
            ContextCompat.getColor(requireActivity(), R.color.background)
        requireActivity().window.decorView.windowInsetsController?.setSystemBarsAppearance(
            0,
            WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
        )
        binding = FragmentOpenTextBinding.bind(
            inflater.inflate(
                R.layout.fragment_open_text,
                container,
                false
            )
        )
        dao = OyinlarDatabase.getInstance(requireContext()).dao()

        binding.txtTitle.text = list[argument-1]
        when(Hawk.get<String>("pref_lang").toString()){
            "qr"->{
                if (argument==1){
                    visibility()
                    binding.txt1.text = dao.getId(1).qr
                    binding.txt2.text = dao.getId(2).qr
                    binding.txt3.text = dao.getId(3).qr
                    binding.txt4.text = dao.getId(4).qr
                }   else{
                    binding.txt4.text = dao.getId(argument+3).qr
                }
            }
            "uz"->{
                if (argument==1){
                    visibility()
                    binding.txt1.text = dao.getId(1).uz
                    binding.txt2.text = dao.getId(2).uz
                    binding.txt3.text = dao.getId(3).uz
                    binding.txt4.text = dao.getId(4).uz
                }   else{
                    binding.txt4.text = dao.getId(argument+3).uz
                }
            }
            "ru"->{
                if (argument==1){
                    visibility()
                    binding.txt1.text = dao.getId(1).ru
                    binding.txt2.text = dao.getId(2).ru
                    binding.txt3.text = dao.getId(3).ru
                    binding.txt4.text = dao.getId(4).ru
                }   else{
                    binding.txt4.text = dao.getId(argument+3).ru
                }
            }
            "en"->{
                if (argument==1){
                    visibility()
                    binding.txt1.text = dao.getId(1).en
                    binding.txt2.text = dao.getId(2).en
                    binding.txt3.text = dao.getId(3).en
                    binding.txt4.text = dao.getId(4).en
                }   else{
                    binding.txt4.text = dao.getId(argument+3).en
                }
            }
        }
        return binding.root
    }
    private fun visibility(){
        binding.txt1.visibility = View.VISIBLE
        binding.txt2.visibility = View.VISIBLE
        binding.txt3.visibility = View.VISIBLE
        binding.img1.visibility = View.VISIBLE
        binding.img2.visibility = View.VISIBLE
        binding.img3.visibility = View.VISIBLE
    }
}