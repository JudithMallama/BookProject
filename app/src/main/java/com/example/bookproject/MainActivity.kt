package com.example.bookproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
//Prueba2
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameBookEditText : EditText = findViewById(R.id.name_book_edit_text)
        val nameAutorEditText : EditText = findViewById(R.id.name_autor_edit_text)
        val pagesEditText : EditText = findViewById(R.id.pages_edit_text)
        val  resumeEditText : EditText = findViewById(R.id.resume_edit_text)



        val saveButton: Button= findViewById(R.id.save_button)
        val infoTextView : TextView = findViewById(R.id.info_text_view)

        saveButton.setOnClickListener {
            val nameBook :String = nameBookEditText.text.toString()
            val autorBook : String = nameAutorEditText.text.toString()
            val pagesBook : String = pagesEditText.text.toString()
            val resumeBook : String =  resumeEditText.text.toString()

            infoTextView.text = nameBook
            infoTextView.text = autorBook
            infoTextView.text = pagesBook
            infoTextView.text = resumeBook//
        }
    }
}