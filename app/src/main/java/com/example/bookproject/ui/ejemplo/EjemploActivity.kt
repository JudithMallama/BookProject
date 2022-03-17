package com.example.bookproject.ui.ejemplo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.bookproject.databinding.ActivityEjemploBinding

class EjemploActivity : AppCompatActivity() {

    private lateinit var ejemploBinding: ActivityEjemploBinding
    private lateinit var ejemploViewModel: EjemploViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ejemploBinding = ActivityEjemploBinding.inflate(layoutInflater)
        setContentView(ejemploBinding.root)

        ejemploViewModel = ViewModelProvider(this).get(EjemploViewModel::class.java)

        ejemploViewModel.totalDone.observe(this) { resul ->
            ejemploBinding.totalTextView.text = "la suma es: $resul"
        }

        ejemploViewModel.msgDone.observe(this) { result ->
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
        }

        with(ejemploBinding) {
            calculateButton.setOnClickListener {
                ejemploViewModel.realizarSuma(
                    numerOneEditText.text.toString(),
                    numberTwoEditText.text.toString()
                )
            }
        }
    }
}