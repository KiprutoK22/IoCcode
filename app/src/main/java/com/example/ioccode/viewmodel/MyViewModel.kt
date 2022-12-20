package com.example.ioccode.viewmodel


import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bernard_di.instance.inject
import com.example.ioccode.model.Result
import com.example.ioccode.repository.IMyRepository
import kotlinx.coroutines.launch

class MyViewModel(
    private val myRepository : IMyRepository = inject(),
    val data : SnapshotStateList<Result> = inject()
) : ViewModel() {


    fun getListOfPaintings() {
        viewModelScope.launch {
            data.addAll(myRepository.getListOfData())
        }
    }

}