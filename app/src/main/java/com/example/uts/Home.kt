package com.example.uts

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Base64
import android.util.Base64OutputStream
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.uts.databinding.ActivityHomeBinding
import java.io.ByteArrayOutputStream
import java.io.File


class Home : AppCompatActivity() {

    private val binding by lazy { ActivityHomeBinding.inflate(layoutInflater) }
    // variable nama
    var nama:String? = null

    // varaible nim
    var nim:String? = null

    // variable image
    var image:String? = null

    val REQUEST_CODE = 100



    private fun openGalleryForImage() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, REQUEST_CODE)

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE){
            binding.btnUpload.setImageURI(data?.data) // handle chosen image
        }

//        val uriPathHelper = URIPathHelper()
//        val filepath = data?.data?.let {  uriPathHelper.getPath(this, it) }
        // assgin var img
        image = data?.data.toString()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.btnUpload.setOnClickListener{ //click upload img
            openGalleryForImage()
        }

        binding.btnsubmit.setOnClickListener{

            //assign nama dan nim
             nama = binding.edNama.text.toString()
             nim = binding.edNim.text.toString()

            val intent = Intent(this,Tampil::class.java)
            intent.putExtra("nama", nama)
            intent.putExtra("nim", nim)
            intent.putExtra("image", image)
            startActivity(intent)
            finish()


        }
    }
}