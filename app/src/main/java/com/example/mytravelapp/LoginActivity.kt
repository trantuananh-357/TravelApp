package com.example.mytravelapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mytravelapp.databinding.ActivityMainBinding
private lateinit var binding : ActivityMainBinding

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding = ActivityMainBinding.inflate(layoutInflater)


    }
}