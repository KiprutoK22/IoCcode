package com.example.ioccode.apolloapi

import com.apollographql.apollo3.ApolloClient
import com.example.ioccode.ListCountriesQuery
import com.example.ioccode.model.Result

interface IApolloClientDependency  {
    fun getApolloClient(): ApolloClient
    suspend fun getListOfAllData() : List<Result>
}