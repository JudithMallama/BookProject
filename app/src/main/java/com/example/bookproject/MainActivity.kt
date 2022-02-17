package com.example.bookproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.bookproject.databinding.ActivityMainBinding

//Prueba2
class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding :ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(mainBinding.root)

        //val nameBookEditText : EditText = findViewById(R.id.name_book_edit_text)

        var numero : Int? = null
        numero = null

        with(mainBinding) {
            saveButton.setOnClickListener {

                if(nameBookEditText.text.isEmpty() ||
                    nameAutorEditText.text.isNotEmpty() ||
                    pagesEditText.text?.isEmpty() == true)
                    {
                        val nameBook: String = nameBookEditText.text.toString()
                        val autorBook = nameAutorEditText.text.toString()
                        val pagesBook = pagesEditText.text.toString().toInt()
                        val resumeBook = resumeEditText.text.toString()

                        infoTextView.text = "name: " + nameBook
                        infoTextView.text = autorBook
                        //mainBinding.infoTextView.text = pagesBook
                        infoTextView.text = resumeBook//
                }
            }
        }
    }
}