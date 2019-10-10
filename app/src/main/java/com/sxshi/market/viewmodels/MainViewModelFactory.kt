package com.sxshi.market.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sxshi.market.data.FruitRepository

class MainViewModelFactory(private val fruitRepository: FruitRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(fruitRepository) as T
    }
}