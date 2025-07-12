package com.example.tugas3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(
    // Ubah 'list' menjadi 'var' agar bisa diperbarui oleh fungsi updateData
    private var list: List<User>,
    private val onDelete: (String) -> Unit
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvText: TextView = view.findViewById(android.R.id.text1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_1, parent, false)
        return UserViewHolder(v)
    }

    // Perbaiki implementasi getItemCount() agar mengembalikan jumlah item dalam 'list'
    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = list[position]
        holder.tvText.text = "${user.name} - ${user.email}"
        holder.itemView.setOnClickListener {
            onDelete(user.id)
        }
    }

    /**
     * Fungsi untuk memperbarui data dalam adapter dari ViewModel.
     * Ini akan menyelesaikan error 'updateData' yang tidak ditemukan.
     */
    fun updateData(newUsers: List<User>) {
        // Perbarui properti 'list' dengan daftar baru
        this.list = newUsers

        // Beri tahu RecyclerView bahwa data telah berubah
        notifyDataSetChanged()
    }
}