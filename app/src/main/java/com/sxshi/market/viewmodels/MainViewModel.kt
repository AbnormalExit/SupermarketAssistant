package com.sxshi.market.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sxshi.market.data.Fruit
import com.sxshi.market.data.FruitRepository
import kotlinx.coroutines.launch

class MainViewModel internal constructor(private val fruitRepository: FruitRepository) :
    ViewModel() {


    public fun getFruit(fruitName: String): LiveData<Fruit> {
        return fruitRepository.getFruit(fruitName)
    }


    public fun addFruit(fruit: Fruit) {
        viewModelScope.launch {
            fruitRepository.insert(fruit)
        }
    }

    public fun deleteFruit(fruit: Fruit) {
        viewModelScope.launch {
            fruitRepository.delete(fruit)
        }
    }
}
