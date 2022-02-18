package com.example.bookproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bookproject.databinding.ActivityMainBinding

//Prueba2
class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(mainBinding.root)

        //val nameBookEditText : EditText = findViewById(R.id.name_book_edit_text)

        with(mainBinding) {
            saveButton.setOnClickListener {

                if (nameBookEditText.text.isEmpty() ||
                    nameAutorEditText.text.isEmpty() ||
                    pagesEditText.text?.isEmpty() == true
                ) {
                    Toast.makeText(
                        applicationContext,
                        "Debe digitar nombre, autor y número de páginas",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    val nameBook: String = nameBookEditText.text.toString()
                    val autorBook = nameAutorEditText.text.toString()
                    val pagesBook = pagesEditText.text.toString().toInt()
                    val resumeBook = resumeEditText.text.toString()
                    var genereBook= ""

                    if (suspenceCheckBox.isChecked) genereBook =" Suspenso"
                    if (terrorCheckBox.isChecked) genereBook +=" Terror"
                    if(infantileCheckBox.isChecked) genereBook +=" Infantil"
                    if(comicCheckBox.isChecked) genereBook +=" Comedia"


                    infoTextView.text = getString(R.string.info, nameBook, autorBook, pagesBook, resumeBook, genereBook)
              }

            }
        }
    }
}