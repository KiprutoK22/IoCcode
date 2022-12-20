package com.example.ioccode.repository

import com.example.bernard_di.instance.inject
import com.example.ioccode.apolloapi.IApolloClientDependency
import com.example.ioccode.model.Result

interface IMyRepository {
    suspend fun getListOfData(): List<Result>
}

class MyRepository(
    private val apolloClient: IApolloClientDependency = inject()
) : IMyRepository {
    override suspend fun getListOfData(): List<Result> {
        return apolloClient.getListOfAllData()
    }
}