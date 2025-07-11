package com.example.tugas2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import android.content.Intent // Tambahkan import Intent

class signup : AppCompatActivity() {
    private lateinit var etEmailUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnCreateAccount: ImageView
    private lateinit var btnLogIn: ImageView
    private lateinit var imgGoogleIcon: ImageView
    private lateinit var imgFacebookIcon: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        // Inisialisasi view
        etEmailUsername = findViewById(R.id.et_email_username)
        etPassword = findViewById(R.id.et_password)
        btnCreateAccount = findViewById(R.id.btn_create_account)
        btnLogIn = findViewById(R.id.btn_log_in)
        imgGoogleIcon = findViewById(R.id.img_google_icon)
        imgFacebookIcon = findViewById(R.id.img_facebook_icon)

        // Aksi Tombol "Create an Account"
        btnCreateAccount.setOnClickListener {
            val emailUsername = etEmailUsername.text.toString()
            val password = etPassword.text.toString()

            if (emailUsername.isNotEmpty() && password.isNotEmpty()) {
                // Logika pendaftaran
                Toast.makeText(this, "Pendaftaran berhasil untuk: $emailUsername", Toast.LENGTH_SHORT).show()

                // LANGKAH 3: Pindah ke MainContentActivity setelah pendaftaran berhasil
                val mainContentIntent = Intent(this, main_content::class.java)
                startActivity(mainContentIntent)

                // Tutup Activity signup agar pengguna tidak kembali ke layar ini dengan tombol back
                finish()

            } else {
                Toast.makeText(this, "Mohon isi Username/Email dan Password", Toast.LENGTH_SHORT).show()
            }
        }

        // Aksi Tombol "Log In"
        btnLogIn.setOnClickListener {
            Toast.makeText(this, "Pindah ke layar Log In", Toast.LENGTH_SHORT).show()
        }

        // Aksi Ikon Sosial
        imgGoogleIcon.setOnClickListener {
            Toast.makeText(this, "Masuk dengan Google (Fitur tidak berfungsi)", Toast.LENGTH_SHORT).show()
        }

        imgFacebookIcon.setOnClickListener {
            Toast.makeText(this, "Masuk dengan Facebook (Fitur tidak berfungsi)", Toast.LENGTH_SHORT).show()
        }
    }
}