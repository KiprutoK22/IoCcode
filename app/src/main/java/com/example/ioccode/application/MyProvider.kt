package com.example.ioccode.application

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.bernard_di.instance.factory
import com.example.bernard_di.provider.IProvider
import com.example.ioccode.ListCountriesQuery
import com.example.ioccode.apolloapi.ApolloClientDependencyImp
import com.example.ioccode.apolloapi.IApolloClientDependency
import com.example.ioccode.model.Result
import com.example.ioccode.repository.IMyRepository
import com.example.ioccode.repository.MyRepository


class MyProvider : IProvider {
    override fun init() {
        factory<IApolloClientDependency> { ApolloClientDependencyImp() }
        factory<IMyRepository> { MyRepository() }
        factory<SnapshotStateList<Result>> { mutableStateListOf() }
    }
}