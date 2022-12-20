package com.example.ioccode.apolloapi

import com.apollographql.apollo3.ApolloClient
import com.example.ioccode.ListCountriesQuery
import com.example.ioccode.model.NETWORK_URL
import com.example.ioccode.model.Query
import com.example.ioccode.model.Result

class ApolloClientDependencyImp : IApolloClientDependency {
    private lateinit var apolloClient: ApolloClient
    override fun getApolloClient(): ApolloClient {
        if(!::apolloClient.isInitialized) {
            apolloClient = ApolloClient.Builder().serverUrl(NETWORK_URL).build()
        }
        return apolloClient
    }

    override suspend fun getListOfAllData() : List<Result>{
        val client = getApolloClient()
        val response = client.query(ListCountriesQuery()).execute()

        return mutableListOf<Result>().also {
            it.addAll(response.data?.countries ?: listOf())
        }
    }

}