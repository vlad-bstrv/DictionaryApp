package com.vladbstrv.dictionaryapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.vladbstrv.dictionaryapp.databinding.ActivityMainBinding
import com.vladbstrv.dictionaryapp.ui.adapter.MainAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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