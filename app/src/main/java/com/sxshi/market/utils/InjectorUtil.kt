package com.sxshi.market.utils

import android.content.Context
import com.sxshi.market.data.AppDatabase
import com.sxshi.market.data.FruitRepository
import com.sxshi.market.viewmodels.MainViewModelFactory

object InjectorUtil {

    fun providerMainViewModelFactory(context: Context): MainViewModelFactory {
        val repository: FruitRepository = getFruitRepository(context)
        return MainViewModelFactory(repository)
    }

    private fun getFruitRepository(context: Context): FruitRepository {
        return FruitRepository.getInstance(AppDatabase.getInstance(context.applicationContext).fruitDao())
    }
}