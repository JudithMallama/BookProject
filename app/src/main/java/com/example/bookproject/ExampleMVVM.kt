package com.example.bookproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.bookproject.databinding.ActivityExampleMvvmBinding

class ExampleMVVM : AppCompatActivity() {

    private lateinit var exampleMvvmBinding: ActivityExampleMvvmBinding
    private lateinit var exampleMVVMViewModel: ExampleMVVMViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        exampleMvvmBinding= ActivityExampleMvvmBinding.inflate(layoutInflater)
        setContentView(exampleMvvmBinding.root)

        exampleMVVMViewModel = ViewModelProvider(this).get(exampleMVVMViewModel::class.java)

        with(exampleMvvmBinding){
            calculateButton.setOnClickListener{
                exampleMVVMViewModel.realizarSuma(
                    numerOneEditText.text.toString().toInt(),
                    numberTwoEditText.text.toString().toInt()
                )
            }
        }
    }
}