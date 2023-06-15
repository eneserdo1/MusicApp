package com.app.movieapp.presentation.ui.movieCount.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.app.movieapp.R
import com.app.movieapp.databinding.FragmentMovieCountBinding
import com.app.movieapp.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieCountFragment : BaseFragment<FragmentMovieCountBinding>(FragmentMovieCountBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    companion object {
        fun newInstance() = MovieCountFragment()

    }
}