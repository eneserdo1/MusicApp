package com.app.movieapp.presentation.ui.movieList.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.movieapp.R
import com.app.movieapp.databinding.FragmentMovieListBinding
import com.app.movieapp.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieListFragment :
    BaseFragment<FragmentMovieListBinding>(FragmentMovieListBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    companion object {
        fun newInstance() = MovieListFragment()
    }
}