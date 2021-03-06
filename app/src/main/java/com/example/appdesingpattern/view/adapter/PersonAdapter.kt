package com.example.appdesingpattern.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appdesingpattern.databinding.PersonItemBinding
import com.example.appdesingpattern.domain.model.Person

class PersonAdapter(private var listPerson: List<Person>)
    : RecyclerView.Adapter<PersonAdapter.ViewHolder>()
{
    inner class ViewHolder(val binding: PersonItemBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonAdapter.ViewHolder {
        val binding = PersonItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PersonAdapter.ViewHolder, position: Int) {
        with(holder) {
            with(listPerson[position]) {
                binding.name.text = name
                binding.gender.text = gender
            }
        }
    }

    override fun getItemCount(): Int {
        return listPerson.size
    }

    fun listPerson(list: List<Person>) {
        listPerson = list
        notifyDataSetChanged()
    }
}