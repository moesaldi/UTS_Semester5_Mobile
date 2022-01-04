package com.example.uts

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.util.Log
import com.example.uts.databinding.ActivityHomeBinding
import com.example.uts.databinding.ActivityTampilBinding

class Tampil : AppCompatActivity() {

    private val binding by lazy { ActivityTampilBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


       val intent = intent
        val tvNama = intent.getStringExtra("nama")
        val tvNim = intent.getStringExtra("nim")
        val tampilFoto = intent.getStringExtra("image")

        tampilFoto?.let {
            binding.tampilFoto.setImageURI(Uri.parse(tampilFoto))
        }

        binding.tvNama.text = tvNama
        binding.tvNim.text = tvNim

        binding.btnNext.setOnClickListener{
            val intent = Intent(this,List::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun decodePicString (encodedString: String): Bitmap {

        val imageBytes = Base64.decode(encodedString, Base64.DEFAULT)
        val decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)

        return decodedImage
    }



}