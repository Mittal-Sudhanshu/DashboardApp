package com.example.openinapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.openinapp.repository.DataRepository

class MainViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            repository = DataRepository()
        ) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
