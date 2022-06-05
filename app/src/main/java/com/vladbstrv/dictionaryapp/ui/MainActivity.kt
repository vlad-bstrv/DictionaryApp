package com.vladbstrv.dictionaryapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.vladbstrv.dictionaryapp.app
import com.vladbstrv.dictionaryapp.databinding.ActivityMainBinding
import com.vladbstrv.dictionaryapp.domain.entities.WordData
import com.vladbstrv.dictionaryapp.ui.adapter.MainAdapter

class MainActivity : AppCompatActivity(), MainActivityContract.View {

    private lateinit var binding: ActivityMainBinding
    private var presenter: MainActivityContract.Presenter? = null
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = MainActivityPresenter(app.wordsRepo)
        presenter?.onAttach(this)

        binding.searchWordButton.setOnClickListener {
            presenter?.getTranslateWord(binding.searchWordEditText.text.toString())
        }
    }

    override fun setSuccess(words: List<WordData>) {
        with(binding.wordsRecyclerView) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = MainAdapter(words)
        }
    }


    override fun setError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    override fun showProgress() {
        with(binding){
            progressBar.visibility = View.VISIBLE
            searchWordButton.isEnabled = false
        }

    }

    override fun hideProgress() {
        with(binding) {
            progressBar.visibility = View.GONE
            searchWordButton.isEnabled = true
        }
    }
}