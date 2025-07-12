package com.example.tugas3

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData

@HiltViewModel
class UserViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    val users: LiveData<List<User>> = repository.getUsers()

    fun addUser(name: String, email: String) {
        val user = User(name = name, email = email)
        repository.addUser(user)
    }

    fun deleteUser(id: String) {
        repository.deleteUser(id)
    }
}
