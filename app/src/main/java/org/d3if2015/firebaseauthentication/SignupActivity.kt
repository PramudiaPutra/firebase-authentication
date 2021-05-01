package org.d3if2015.firebaseauthentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.d3if2015.firebaseauthentication.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        binding.registerButton.setOnClickListener { signUp() }
        binding.redirectLogin.setOnClickListener { onBackPressed() }
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
            else -> {
                createAccount(email, password)
            }
        }
    }

    private fun createAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "registration complete, please login with your email and password", Toast.LENGTH_LONG).show()

                    val intent = Intent(this, SigninActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    }
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, task.exception?.message, Toast.LENGTH_LONG).show()
                }
            }
    }
}