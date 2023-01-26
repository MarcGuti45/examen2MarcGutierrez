package com.marc.examen2marcgutierrez

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.marc.examen2marcgutierrez.databinding.FragmentIniBinding
import com.marc.examen2marcgutierrez.viewmodel.MobleViewModel

class FragmentIni : Fragment() {

    private lateinit var binding: FragmentIniBinding
    private lateinit var mobleViewModel: MobleViewModel

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