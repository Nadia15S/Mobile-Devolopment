package com.example.tugas2

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class main_content : AppCompatActivity() {
    private lateinit var imgProfilePic: ImageView
    private lateinit var tvUserName: TextView
    private lateinit var tvUserId: TextView
    private lateinit var imgProductGallery: ImageView // Placeholder untuk galeri
    private lateinit var tvNeutralTone: TextView
    private lateinit var tvDescription: TextView
    private lateinit var imgDecorativeFlower: ImageView
    private lateinit var menuListLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Menetapkan layout activity_main_content.xml
        setContentView(R.layout.activity_main_content)

        // Inisialisasi views menggunakan findViewById()
        imgProfilePic = findViewById(R.id.img_profile_pic)
        tvUserName = findViewById(R.id.tv_user_name)
        tvUserId = findViewById(R.id.tv_user_id)
        imgProductGallery = findViewById(R.id.img_product_gallery)
        tvNeutralTone = findViewById(R.id.tv_neutral_tone)
        tvDescription = findViewById(R.id.tv_description)
        imgDecorativeFlower = findViewById(R.id.img_decorative_flower)
        menuListLayout = findViewById(R.id.menu_list_layout)

        // Contoh pengaturan data ke TextView
        tvUserName.text = "Nanaciciya"
        tvUserId.text = "ID: 1524367890"

        // Catatan: Jika Anda ingin mengisi data gambar ke ImageView (misalnya imgProductGallery atau imgProfilePic)
        // Anda perlu menggunakan library seperti Glide jika gambar berasal dari URL, atau
        // mengatur sumber daya drawable jika gambar ada di folder res/drawable.
    }
}