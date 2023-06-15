package com.app.movieapp.presentation.ui.movieGridList.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.app.movieapp.R
import com.app.movieapp.databinding.FragmentMovieGridListBinding
import com.app.movieapp.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieGridListFragment : BaseFragment<FragmentMovieGridListBinding>(FragmentMovieGridListBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    companion object {
        fun newInstance() = MovieGridListFragment()
    }
}