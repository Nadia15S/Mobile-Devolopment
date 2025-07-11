package com.example.tugas2

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class splash2 : AppCompatActivity() {

    // Durasi layar splash (3 detik)
    private val SPLASH_DELAY_MS: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Menetapkan layout activity_splash2.xml
        setContentView(R.layout.activity_splash2)

        // --- Logika Memuat Gambar dengan Glide ---
        // (Pastikan ID-ID ini ada di layout XML Anda dan kompatibel untuk ImageView jika Anda memuat gambar)

        // Memuat gambar ke ID yang ada di XML
        loadGlideImage(R.id.rifpezi2gjhn, "https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/ba35ac3c-7411-44bc-9e51-c493ec22a640") // Ikon Utama
        loadGlideImage(R.id.rx3bc1agey7k, "https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/3dbc336e-bcfa-4564-9863-a0b569ac7472") // Dekorasi Kanan Atas
        loadGlideImage(R.id.r778uaaxh74f, "https://figma-alpha-api.s3.us-west-2.amazonaws.com/images/bc606341-c9d9-4c15-a49f-ce9e3664cc47") // Dekorasi Kiri Bawah
        val tvGlowTitle: TextView = findViewById(R.id.tv_glow_title)
        tvGlowTitle.text = "Glow"

        val tvSubtitle: TextView = findViewById(R.id.tv_subtitle)
        tvSubtitle.text = "A Care Recommendation for Your Skin"
        // --- Logika Penundaan dan Transisi ---
        Handler(Looper.getMainLooper()).postDelayed({

            // Perubahan: Pindah dari splash2 ke SignUpActivity (Langkah 2)
            val nextIntent = Intent(this, signup::class.java)
            startActivity(nextIntent)

            // Tutup Activity splash screen agar pengguna tidak bisa kembali
            finish()

        }, SPLASH_DELAY_MS)
    }

    /**
     * Helper function untuk memuat gambar menggunakan Glide ke ImageView berdasarkan ID.
     */
    private fun loadGlideImage(imageViewId: Int, imageUrl: String) {
        // Menggunakan findViewById<ImageView>() untuk mencari ImageView
        val imageView = findViewById<ImageView>(imageViewId)

        // Memastikan ImageView ditemukan sebelum memuat gambar
        imageView?.let {
            Glide.with(this)
                .load(imageUrl)
                .into(it)
        }
    }
}