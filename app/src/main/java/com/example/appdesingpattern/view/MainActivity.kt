package com.example.appdesingpattern.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.appdesingpattern.R
import com.example.appdesingpattern.databinding.ActivityMainBinding
import com.example.appdesingpattern.view.adapter.PersonAdapter
import com.example.appdesingpattern.view.components.PersonDialog
import com.example.appdesingpattern.viewmodel.PersonViewModel
import com.example.appdesingpattern.viewmodel.PersonViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var personViewModel: PersonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setupViewModel()
        setUpObserver()

        binding.fabadd.setOnClickListener {
            val dialog = PersonDialog(
                onSubmitClickListener = {
                    personViewModel.add(it)
                }
            ).show(this.supportFragmentManager, "NewPerson")
        }
    }

    private fun setupViewModel() {
        personViewModel = ViewModelProvider(this, PersonViewModelFactory(this.application))
            .get(PersonViewModel::class.java)

        personViewModel.onCreate()
    }

    private fun setUpObserver() {
        binding.rvperson.layoutManager = GridLayoutManager(applicationContext, 2)
        personViewModel.listPerson.observe(this, Observer {
            binding.rvperson.adapter = PersonAdapter(it)
        })

        personViewModel.isLoading.observe(this, Observer {
            binding.loading.isVisible = it
        })
    }
}