package com.example.mytravelapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.WindowDecorActionBar
import com.example.mytravelapp.databinding.ActivityLoginBinding
import com.example.mytravelapp.databinding.ActivityMainBinding
import java.util.regex.Pattern

private lateinit var binding : ActivityLoginBinding

class LoginActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
         emailFoucusListener()
        passwordFoucusListener()
        submitForm(this)



    }


    private fun submitForm(activity: Activity){
        binding.btnSubmitForm.setOnClickListener{
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
        }
    }


    private fun emailFoucusListener() {
        binding.editTextEmail.setOnFocusChangeListener{_, focused ->
            if(!focused){
                binding.ContainerEmail.helperText =  validEmail()
            }

        }
    }

    private fun validEmail(): String?{
        val emailText = binding.editTextEmail.text.toString()
        if(!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()){
            return "Invalid Email Address"
        }


        return null
    }

    private fun passwordFoucusListener() {
        binding.editTextPassWord.setOnFocusChangeListener{_, focused ->
            if(!focused){
                binding.ContainerPassWord.helperText =  validPassword()
            }
        }
    }

    private fun validPassword(): String?{
        val password = binding.editTextPassWord.text.toString()
        if(password.length < 8){
            return "Minimum 8 character Password"
        }
        if(password.matches(".*[A-Z].*".toRegex())){
            return "1 Upper-Case Character"
        }

        if(password.matches(".*[a-z].*".toRegex())){
            return "1 Lower-Case Character"
        }
        if(password.matches(".*?=.*[@#\$%^&+=].*".toRegex())){
            return "1 Special Character (?=.*[@#\$%^&+=])"
        }



        return null
    }

}
