package org.d3if2015.firebaseauthentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import org.d3if2015.firebaseauthentication.databinding.ActivitySigninBinding

class SigninActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySigninBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener { signIn() }

        binding.redirectRegister.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }

    private fun signIn() {
        val email = binding.emailLogin.text.toString()
        val password = binding.passwordLogin.text.toString()
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