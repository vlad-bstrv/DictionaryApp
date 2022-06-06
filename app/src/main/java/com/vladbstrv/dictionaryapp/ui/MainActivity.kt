package com.vladbstrv.dictionaryapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.vladbstrv.dictionaryapp.app
import com.vladbstrv.dictionaryapp.databinding.ActivityMainBinding
import com.vladbstrv.dictionaryapp.domain.entities.WordData
import com.vladbstrv.dictionaryapp.domain.repositories.WordsRepository
import com.vladbstrv.dictionaryapp.ui.adapter.MainAdapter
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    @Inject
    lateinit var vmFactory: MainActivityViewModelFactory
    private val viewModel: MainActivityViewModelContract.ViewModel by lazy {
        ViewModelProvider(this, vmFactory)[(MainActivityViewModel::class.java)]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        app.appComponent.inject(this)

        binding.searchWordButton.setOnClickListener {
            viewModel.getTranslateWord(binding.searchWordEditText.text.toString())
        }

        viewModel.data.observe(this) {
            with(binding.wordsRecyclerView) {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = MainAdapter(it)
            }
        }

        viewModel.inProgress.observe(this) {
            with(binding) {
                progressBar.isVisible = it
                searchWordButton.isEnabled = !it
            }
        }
    }
}