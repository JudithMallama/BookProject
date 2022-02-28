package com.example.bookproject

import android.util.Log
import androidx.lifecycle.ViewModel

class ExampleMVVMViewModel: ViewModel() {
    fun realizarSuma(num1:Int, num2: Int) {
        val total = num1 + num2
        Log.d("suma",total.toString())
    }
}