package com.example.uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.uts.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {

    private val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnSigninLogin.setOnClickListener{
            val username = binding.username.text.toString()
            val password = binding.password.text.toString()

            if (username.isEmpty()||password.isEmpty()){
                Toast.makeText(this, "Masukan username dan password!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (username == "admin" && password == "123"){
                val masuk = Intent(this,Home::class.java)
                startActivity(masuk)
                finish()
            }

            else{
                Toast.makeText(this, "Username atau password salah", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
        }

    }
}