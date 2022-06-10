package com.example.appdesingpattern.view.components

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.appdesingpattern.databinding.PersonDialogBinding
import com.example.appdesingpattern.domain.model.Person

class PersonDialog(private val onSubmitClickListener: (person: Person) -> Unit): DialogFragment() {
    private lateinit var binding: PersonDialogBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = PersonDialogBinding.inflate(LayoutInflater.from(context))

        val builder = AlertDialog.Builder(requireActivity())
        builder.setView(binding.root)

        binding.btnsave.setOnClickListener {
            if (binding.textname.text.isEmpty()) {
                Toast.makeText(context, "Name is required", Toast.LENGTH_SHORT).show()
            } else {
                val p = Person(binding.textname.text.toString(), "male")
                onSubmitClickListener.invoke(p)
                dismiss()
            }
        }

        val dialog = builder.create()
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return dialog
    }
}