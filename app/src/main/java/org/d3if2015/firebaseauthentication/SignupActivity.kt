package org.d3if2015.firebaseauthentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import org.d3if2015.firebaseauthentication.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerButton.setOnClickListener { signUp() }
        binding.redirectLogin.setOnClickListener {
            onBackPressed()
        }
    }

    private fun signUp() {
        val email = binding.emailRegister.text.toString()
        val password = binding.passwordRegister.text.toString()

        when {
            TextUtils.isEmpty(email) -> {
                Toast.makeText(this, "email is empty", Toast.LENGTH_SHORT).show()
            }

            TextUtils.isEmpty(password) -> {
                Toast.makeText(this, "password is empty", Toast.LENGTH_SHORT).show()
            }
            else -> { }
        }
    }
}