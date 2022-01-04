package com.example.uts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uts.Adapter.AdapterList
import com.example.uts.databinding.ActivityListBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class List : AppCompatActivity() {
    private val binding by lazy { ActivityListBinding.inflate(layoutInflater) }
    private lateinit var adapter: AdapterList
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val db = Firebase.firestore

        db.collection("ikan")
            .get()
            .addOnSuccessListener { result ->
                val listIkan = mutableListOf<String>()
                //Menampilkan data kedalam recyclerview
                for (document in result) {
                    listIkan.add(document.data["namaIkan"].toString())
//                    Log.d("list", listIkan.toString())
                }
                binding.rvIkan.layoutManager = LinearLayoutManager(this)
                binding.rvIkan.adapter = AdapterList(listIkan)

            }
            .addOnFailureListener { exception ->
                Log.w("error", "Error getting documents.", exception)
            }

    }
}