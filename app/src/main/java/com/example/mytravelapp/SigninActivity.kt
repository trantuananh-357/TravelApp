package com.example.mytravelapp

import android.app.Activity
import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.graphics.toColor
import com.example.mytravelapp.databinding.ActivityMainBinding
import com.example.mytravelapp.databinding.ActivitySigninBinding

private lateinit var binding : ActivitySigninBinding

class SigninActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(binding.root)


        userNameFocusListener(this)
        passwordForcusListener(this)
        rePasswordFocusListener(this)
        submitForm(this)





    }

    private fun submitForm(activity : Activity) {
        binding.btnSubmitForm.setOnClickListener{
            val intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
        }


    }


    private fun userNameFocusListener(activity: Activity) {
        binding.editTextUsername.setOnFocusChangeListener{_, focused ->
            if(!focused) {
                binding.ContainerUsername.helperText = validUserName(activity)
            }
            if(focused){
                binding.ContainerUsername.setHelperTextColor(ColorStateList.valueOf(ContextCompat.getColor(activity, R.color.color_suscessful)))
                binding.ContainerUsername.helperText = "The username good has Lower-Case, UpperCase, and 1 special character"
            }
        }



    }

    private fun validUserName(activity: Activity): String? {
        val userName = binding.editTextUsername.text.toString()



        if(userName.matches(".*[^(?=.{8,20}\$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])\$].*".toRegex())){
//            binding.ContainerUsername.setHelperTextColor(ColorStateList.valueOf(ContextCompat.getColor(activity, R.color.color_suscessful)))
            binding.iconCheckUserName.visibility = View.VISIBLE
            return null
        }
        else{
            binding.ContainerUsername.setHelperTextColor(ColorStateList.valueOf(ContextCompat.getColor(activity, R.color.color_error)))
            binding.iconCheckUserName.visibility = View.INVISIBLE



            if(userName.matches(".*[a-z].*".toRegex())){

                return "1 Lower-Case Character"
            }
            if(userName.matches(".*[0-9].*".toRegex())){
                return "1 Number Character"

            }
            if(userName.matches(".*[A-Z].*".toRegex())){
                return "1 Upper-Case Character"
            }



        }

        return null
    }

    private fun passwordForcusListener(activity : Activity) {
        binding.editTextPassWord.setOnFocusChangeListener{_, focused ->
            if(!focused) {
                binding.ContainerPassWord.helperText = validPassword(activity)
            }
        }

    }

    private fun validPassword(activity: Activity): String? {
        val password = binding.editTextPassWord.text.toString()
        if(password.matches(".*[^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%^&+=])(?=\\\\S+\$).{4,}\$].*".toRegex())){
//            binding.ContainerPassWord.setHelperTextColor(ColorStateList.valueOf(ContextCompat.getColor(activity, R.color.color_suscessful)))
            binding.iconCheckPassword.visibility = View.VISIBLE
            return null
        }
        else{
            binding.ContainerPassWord.setHelperTextColor(ColorStateList.valueOf(ContextCompat.getColor(activity, R.color.color_error)))
            binding.iconCheckUserName.visibility = View.INVISIBLE

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


        }


        return null
    }
    private fun rePasswordFocusListener(activity: Activity) {
        binding.editTextRePassWord.setOnFocusChangeListener{_, focused ->
            if(!focused){
                binding.ContainerRepassWord.helperText = validRepassword(activity)

            }
        }




    }

    private fun validRepassword(activity: Activity): String? {
        val password = binding.editTextPassWord.text.toString()
        val repassword = binding.editTextRePassWord.text.toString()
        if(password == null){

            return "Fristly,You must type the password!"
        }
        else
        {
            if(password == repassword){
//                binding.ContainerRepassWord.setHelperTextColor(ColorStateList.valueOf(ContextCompat.getColor(activity, R.color.color_suscessful)))
                binding.iconRepassword.visibility = View.VISIBLE
                return null
            }
            else{
                binding.iconRepassword.visibility = View.INVISIBLE


                binding.ContainerRepassWord.setHelperTextColor(ColorStateList.valueOf(ContextCompat.getColor(activity, R.color.color_error)))
                return "No match with password"
            }

        }

        return null

    }
}