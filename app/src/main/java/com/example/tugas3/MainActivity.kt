package com.example.tugas3

import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.viewModels

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: UserViewModel by viewModels()
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val etName = findViewById<EditText>(R.id.etName)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val rvUsers = findViewById<RecyclerView>(R.id.rvUsers)

        adapter = UserAdapter(emptyList()) { id ->
            viewModel.deleteUser(id)
        }

        rvUsers.adapter = adapter
        rvUsers.layoutManager = LinearLayoutManager(this)

        viewModel.users.observe(this) { users ->
            adapter.updateData(users)
        }

        btnAdd.setOnClickListener {
            val name = etName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            if (name.isNotEmpty() && email.isNotEmpty()) {
                viewModel.addUser(name, email)
                etName.text.clear()
                etEmail.text.clear()
            }
        }
    }
}
