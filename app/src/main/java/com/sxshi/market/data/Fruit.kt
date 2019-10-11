package com.sxshi.market.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "t_fruits")
class Fruit(
    @PrimaryKey
    val fruitName: String,
    val fruitCode: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Fruit

        if (fruitName != other.fruitName) return false
        if (fruitCode != other.fruitCode) return false

        return true
    }

    override fun hashCode(): Int {
        var result = fruitName.hashCode()
        result = 31 * result + fruitCode.hashCode()
        return result
    }
}

