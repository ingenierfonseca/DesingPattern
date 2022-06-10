package com.example.appdesingpattern.view

import android.os.Bundle
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.example.appdesingpattern.viewmodel.PersonViewModel

class CardDialogFragment : DialogFragment() {
    private lateinit var personViewModel: PersonViewModel
    private lateinit var txtname: EditText
    private lateinit var gender: EditText

    companion object {

    }
}