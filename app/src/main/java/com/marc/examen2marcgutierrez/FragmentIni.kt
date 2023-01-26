package com.marc.examen2marcgutierrez

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.marc.examen2marcgutierrez.databinding.FragmentIniBinding

class FragmentIni : Fragment() {

    private lateinit var binding: FragmentIniBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_ini, container,false
        )

        binding.buttonAfegirNou.setOnClickListener{
                view : View ->
            view.findNavController().navigate(R.id.action_fragmentIni_to_fragmentInsert)
        }
        return binding.root
    }
}