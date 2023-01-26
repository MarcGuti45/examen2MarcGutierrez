package com.marc.examen2marcgutierrez

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.marc.examen2marcgutierrez.databinding.FragmentInsertBinding
import com.marc.examen2marcgutierrez.model.Moble
import com.marc.examen2marcgutierrez.viewmodel.MobleViewModel

class FragmentInsert : Fragment() {

    private lateinit var binding: FragmentInsertBinding
    lateinit var mobleViewModel: MobleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_insert, container,false
        )

        mobleViewModel = ViewModelProvider(this).get(MobleViewModel::class.java)

        binding.buttonInsert.setOnClickListener {
            val nom = binding.editTextNom.text.toString()
            val preu = binding.editTextPreu.text.toString().toInt()

            mobleViewModel.newMoble(requireContext(), nom, preu)

        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.
        onNavDestinationSelected(item,requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

}