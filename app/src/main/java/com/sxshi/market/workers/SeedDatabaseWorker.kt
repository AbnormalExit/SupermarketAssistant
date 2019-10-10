package com.sxshi.market.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.sxshi.market.data.AppDatabase
import com.sxshi.market.data.Fruit
import kotlinx.coroutines.coroutineScope

class SeedDatabaseWorker(context: Context, workerParameters: WorkerParameters) :
    CoroutineWorker(context, workerParameters) {

    override suspend fun doWork(): Result = coroutineScope {
        try {
            applicationContext.assets.open("fruits.json").use { inputStream ->
                JsonReader(inputStream.reader()).use { jsonReader ->
                    val fruitType = object : TypeToken<List<Fruit>>() {}.type
                    val fruits: List<Fruit> = Gson().fromJson(jsonReader, fruitType)

                    val database = AppDatabase.getInstance(applicationContext)
                    database.fruitDao().insertAll(fruits)

                    Result.success()
                }
            }
        } catch (ex: Exception) {
            Log.e(TAG, "Error seeding database", ex)
            Result.failure()
        }
    }

    companion object {
        private val TAG = SeedDatabaseWorker::class.java.simpleName
    }
}