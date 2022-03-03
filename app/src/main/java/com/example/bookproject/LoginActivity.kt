package com.example.bookproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bookproject.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var loginBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)

        val credentials = intent.extras
        var emailReceived :String? = ""
        var passwordReceived :String? = ""

        if (credentials != null) {
            emailReceived = credentials.getString("email")
            passwordReceived = credentials.getString("password")
        }

        loginBinding.registerTextView.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        loginBinding.calculoTextView.setOnClickListener {
           val intent = Intent(this, EjemploActivity::class.java)
           startActivity(intent)
        }

        with(loginBinding){
            singInButton.setOnClickListener{
                val email = emailEditText.text.toString()
                val password= passwordTextEdit.text.toString()

                if(email == emailReceived && password == passwordReceived && email.isNotEmpty() && password.isNotEmpty())
                    {
                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(intent)
                }else {
                    Toast.makeText(this@LoginActivity, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()

                }
            }
        }


    }
}