package com.usd.movieapplication.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.usd.movieapplication.databinding.ListItemMovieBinding
import com.usd.movieapplication.model.movie.Movie

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    private val itemCallback = object : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, itemCallback)

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ListItemMovieBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = differ.currentList[position]
        holder.bind(movie)
    }

    class MovieViewHolder(private val binding: ListItemMovieBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            binding.tvName.text = movie.title
            //val posterURL = "https://image.tmdb.org/t/p/w500" + movie.posterPath
/*            Glide.with(binding.imageView.context)
                .load(posterURL)
                .into(binding.imageView)*/
        }

    }

}