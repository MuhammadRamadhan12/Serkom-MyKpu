package com.example.mykpu.tampilan.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mykpu.databinding.ActivityMainBinding
import com.example.mykpu.tampilan.input.FormEntry
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Listener untuk tombol "Informasi", membuka aktivitas Informasi
        binding.buttonInformasi.setOnClickListener {
            val intent = Intent(this, Informasi::class.java)
            startActivity(intent)
        }

        // Listener untuk tombol "Form Entry", membuka aktivitas FormEntry
        binding.buttonFormEntry.setOnClickListener {
            val intent = Intent(this, FormEntry::class.java)
            startActivity(intent)
        }

        // Listener untuk tombol "Lihat Data", membuka aktivitas DaftarDataPemilih
        binding.buttonLihatData.setOnClickListener {
            val intent = Intent(this, DaftarDataPemilih::class.java)
            startActivity(intent)
        }

        // Listener untuk tombol "Keluar", menutup aplikasi
        binding.buttonKeluar.setOnClickListener {
            finish() // Menutup aktivitas (keluar dari aplikasi)
        }
    }
}