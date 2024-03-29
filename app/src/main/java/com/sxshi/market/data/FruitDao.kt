package com.sxshi.market.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FruitDao {

    @Query("SELECT* FROM T_FRUITS WHERE fruitName LIKE '%' || :fruitName || '%'")
    fun getFruit(fruitName: String): LiveData<List<Fruit>>

    @Query("SELECT fruitName FROM T_FRUITS")
    fun getFruitName(): LiveData<List<String>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(fruit: Fruit)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(fruits: List<Fruit>)

    @Delete
    suspend fun delete(fruit: Fruit)
}