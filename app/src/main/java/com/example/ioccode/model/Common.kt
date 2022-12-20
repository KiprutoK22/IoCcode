package com.example.ioccode.model

import com.example.ioccode.ListCountriesQuery

typealias Query = ListCountriesQuery
typealias Result = ListCountriesQuery.Country

val NETWORK_URL  = "https://countries.trevorblades.com/graphql"