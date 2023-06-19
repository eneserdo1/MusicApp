package com.app.musicapp.presentation.ui.main.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.app.musicapp.R
import com.app.musicapp.common.utils.Alert
import com.app.musicapp.common.utils.Alert.Companion.showErrorPopup
import com.app.musicapp.common.utils.ProgressDialogUtil
import com.app.musicapp.databinding.ActivityMainBinding
import com.app.musicapp.presentation.base.BaseActivity
import com.app.musicapp.presentation.ui.main.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {


    private val viewModel: MainViewModel by viewModels()

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initObservers()
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController


        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.tab1 -> {
                    navController.navigate(R.id.musicListFragment)
                    true
                }

                R.id.tab2 -> {
                    navController.navigate(R.id.musicCountFragment)
                    true
                }

                R.id.tab3 -> {
                    navController.navigate(R.id.musicGridListFragment)
                    true
                }

                R.id.tab4 -> {
                    navController.navigate(R.id.musicHorizontalListFragment)
                    true
                }
                else -> {
                    false
                }
            }
        }

    }

    private fun initObservers() {
        viewModel.loading.observe(this) {
            if (it) {
                ProgressDialogUtil.showProgress(this)
            } else {
                ProgressDialogUtil.hideProgress()
            }
        }

        viewModel.error.observe(this) {
            showAlert()
        }
    }

    private fun showAlert() {
        this.showErrorPopup(
            positiveListener = {
                viewModel.refreshData()
            },
            negativeListener = {
                Alert.errorDialog.dismiss()
            })
    }
}