package com.marc.examen2marcgutierrez

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.marc.examen2marcgutierrez.databinding.FragmentDetailBinding
import com.marc.examen2marcgutierrez.viewmodel.MobleViewModel

class FragmentDetail : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    lateinit var mobleViewModel: MobleViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_detail, container,false
        )

        binding.buttonDelete.setOnClickListener {
            val nom = binding.editTextNomDetail.text.toString()
            val preu = binding.editTextPreuDetail.text.toString().toInt()

            mobleViewModel.newMoble(requireContext(), nom, preu)

        }

        binding.buttonUpdate.setOnClickListener {
            val nom = binding.editTextNomDetail.text.toString()
            val preu = binding.editTextPreuDetail.text.toString().toInt()

            mobleViewModel.newMoble(requireContext(), nom, preu)

        }
        return binding.root
    }
}