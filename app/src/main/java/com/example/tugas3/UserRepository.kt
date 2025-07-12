package com.example.tugas3

import javax.inject.Inject
import com.google.firebase.firestore.FirebaseFirestore
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class UserRepository @Inject constructor() {

    private val db = FirebaseFirestore.getInstance()
    private val usersCollection = db.collection("users")

    fun addUser(user: User) {
        val id = usersCollection.document().id
        user.id = id
        usersCollection.document(id).set(user)
    }

    fun getUsers(): LiveData<List<User>> {
        val usersLiveData = MutableLiveData<List<User>>()
        usersCollection.addSnapshotListener { snapshot, error ->
            if (error != null || snapshot == null) return@addSnapshotListener
            val list = snapshot.toObjects(User::class.java)
            usersLiveData.value = list
        }
        return usersLiveData
    }

    fun deleteUser(id: String) {
        usersCollection.document(id).delete()
    }
}
