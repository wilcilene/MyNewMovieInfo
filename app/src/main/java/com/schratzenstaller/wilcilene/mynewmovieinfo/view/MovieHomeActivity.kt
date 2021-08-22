package com.schratzenstaller.wilcilene.mynewmovieinfo.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayoutMediator
import com.schratzenstaller.wilcilene.mynewmovieinfo.R
import com.schratzenstaller.wilcilene.mynewmovieinfo.databinding.ActivityMovieHomeBinding

class MovieHomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        false.also { binding.vpMovies.isUserInputEnabled = it }

        val adapter = MovieViewPager(supportFragmentManager, lifecycle)
        binding.vpMovies.adapter = adapter
        TabLayoutMediator(binding.tlMovies, binding.vpMovies
        ) { tab, position ->
            when (position) {
                1 -> tab.text = getString(R.string.favorites)
                else -> tab.text = getString(R.string.all_movies)
            }
        }.attach()
    }
}
