package com.usd.movieapplication.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.usd.movieapplication.R
import com.usd.movieapplication.data.Resource
import com.usd.movieapplication.databinding.ActivityMovieListBinding
import com.usd.movieapplication.model.movie.Movie
import com.usd.movieapplication.model.movie.MovieList
import com.usd.movieapplication.ui.adapter.MoviesAdapter
import com.usd.movieapplication.ui.viewmodel.MovieListViewModel
import com.usd.movieapplication.ui.viewmodelfactory.MovieListViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MovieListActivity : AppCompatActivity() {

    lateinit var binding: ActivityMovieListBinding
    lateinit var viewModel: MovieListViewModel
    lateinit var adapter: MoviesAdapter

    @Inject
    lateinit var viewModelFactory: MovieListViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_list)
        viewModel = ViewModelProvider(this, viewModelFactory)[MovieListViewModel::class.java]

        setObservers()
        initRecyclerView()
        fetchMovieList()
    }

    private fun setObservers() {
        viewModel.movieList.observe(this, Observer { response ->
            when (response) {

                is Resource.Loading -> {
                    showProgressIndicator()
                }

                is Resource.Success -> {
                    loadMovieList(response.data)
                }

                is Resource.Error -> {
                    hideProgressIndicator()
                }

            }
        })
    }

    private fun fetchMovieList() {
        viewModel.getMovieList()
    }

    private fun showProgressIndicator() {

    }

    private fun hideProgressIndicator() {

    }

    private fun loadMovieList(movieList: MovieList?) {
        movieList?.let { response ->
            adapter.differ.submitList(response.results)
        }
    }

    private fun initRecyclerView() {
        binding.rvMovies.layoutManager = LinearLayoutManager(this)
        adapter = MoviesAdapter()
        binding.rvMovies.adapter = adapter
    }

}