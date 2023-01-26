package com.marc.examen2marcgutierrez.viewmodel

import android.content.Context
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.marc.examen2marcgutierrez.model.Moble
import com.marc.examen2marcgutierrez.repositori.Repository

class MobleViewModel(inflate: View) : ViewModel() {
    var moble: LiveData<List<Moble>>? = null

    //TODO: insert moble
    fun newMoble(context: Context, nom: String, preu: Int ) {

        var mobleVM = Moble(nom, preu)
        Repository.insertMobles(context,mobleVM)
    }

    //TODO: select moble
    fun obtenirMobles(context: Context) : LiveData<List<Moble>>? {
        moble = Repository.getMobles(context)
        return moble
    }
}