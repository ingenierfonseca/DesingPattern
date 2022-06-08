package com.example.appdesingpattern.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.appdesingpattern.R
import com.example.appdesingpattern.databinding.ActivityMainBinding
import com.example.appdesingpattern.view.adapter.PersonAdapter
import com.example.appdesingpattern.viewmodel.PersonViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var personViewModel: PersonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        personViewModel = ViewModelProvider(this)
            .get(PersonViewModel::class.java)

        binding.rvperson.layoutManager = GridLayoutManager(applicationContext, 2)
        personViewModel.personList().observe(this, Observer {
            binding.rvperson.adapter = PersonAdapter(it)
        })
    }
}