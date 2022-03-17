package com.example.bookproject.ui.ejemplo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EjemploViewModel : ViewModel() {

    private val total: MutableLiveData<Int> = MutableLiveData()
    val totalDone: LiveData<Int> = total

    private val msg : MutableLiveData<String> = MutableLiveData()
    val msgDone : LiveData<String> = msg

    fun realizarSuma(num1: String, num2: String) {
        if (num1.isEmpty() || num2.isEmpty()) {
            msg.value = "Debe digitar los dos números"
        } else {
            total.value = num1.toInt() + num2.toInt()
            val suma = num1.toInt() + num2.toInt()
            if(suma % 2 == 0)
                {msg.value = "El total es par"}
            else
                msg.value = " el total es impar"
            Log.d("suma", total.toString())
        }
    }
}