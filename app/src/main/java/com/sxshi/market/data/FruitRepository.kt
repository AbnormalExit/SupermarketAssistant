package com.sxshi.market.data

class FruitRepository private constructor(private val fruitDao: FruitDao) {
    fun getFruit(furitName: String) = fruitDao.getFruit(furitName)

    fun getFruitNames() = fruitDao.getFruitName()

    suspend fun insert(fruit: Fruit) = fruitDao.insert(fruit)

    suspend fun delete(fruit: Fruit) = fruitDao.delete(fruit)

    companion object {
        @Volatile
        private var instance: FruitRepository? = null

        fun getInstance(furitDao: FruitDao) =
            instance ?: FruitRepository(fruitDao = furitDao).also { instance = it }
    }
}