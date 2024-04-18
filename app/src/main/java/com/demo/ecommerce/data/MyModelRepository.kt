package com.demo.ecommerce.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import com.demo.ecommerce.data.local.database.MyModel
import com.demo.ecommerce.data.local.database.MyModelDao
import javax.inject.Inject

interface MyModelRepository {
    val myModels: Flow<List<String>>

    suspend fun add(name: String)
}

class DefaultMyModelRepository @Inject constructor(
    private val myModelDao: MyModelDao
) : MyModelRepository {

    override val myModels: Flow<List<String>> =
        myModelDao.getMyModels().map { items -> items.map { it.name } }

    override suspend fun add(name: String) {
        myModelDao.insertMyModel(MyModel(name = name))
    }
}
