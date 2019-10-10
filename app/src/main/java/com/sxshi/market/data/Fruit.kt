package com.sxshi.market.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "t_fruits")
class Fruit(
    @PrimaryKey @ColumnInfo(name = "id") val fruitId: String,
    val fruitName: String,
    val fruitCode: String
)

