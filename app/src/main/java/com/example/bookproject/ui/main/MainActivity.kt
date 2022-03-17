package com.example.bookproject.ui.main

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.bookproject.R
import com.example.bookproject.databinding.ActivityMainBinding
import com.example.bookproject.ui.login.LoginActivity
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private var cal = Calendar.getInstance()
    private var publicatioDate = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(mainBinding.root)

        //val nameBookEditText : EditText = findViewById(R.id.name_book_edit_text)
 /*
        val dateSetListener = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, month)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val format = "dd/MM/yyyy"
            val simpleDateFormat = SimpleDateFormat(format, Locale.US)
            publicatioDate = simpleDateFormat.format(cal.time).toString()
            mainBinding.publicationDateButton.text = publicatioDate
        }

        with(mainBinding) {

            publicationDateButton.setOnClickListener {
                DatePickerDialog(
                    this@MainActivity,
                    dateSetListener,
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)
                ).show()
            }

            saveButton.setOnClickListener {

                if (nameBookEditText.text?.isEmpty() == true ||
                    nameAutorEditText.text?.isEmpty() == true ||
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
                    var genereBook = ""

                    if (suspenceCheckBox.isChecked) genereBook = " Suspenso"
                    if (terrorCheckBox.isChecked) genereBook += " Terror"
                    if (infantileCheckBox.isChecked) genereBook += " Infantil"
                    if (comicCheckBox.isChecked) genereBook += " Comedia"

                    val score = when {
                        oneRadioButton.isChecked -> 1
                        twoRadioButton.isChecked -> 2
                        threeRadioButton.isChecked -> 3
                        fourRadioButton.isChecked -> 4
                        else -> 5
                    }



                    infoTextView.text = getString(
                        R.string.info,
                        nameBook,
                        autorBook,
                        pagesBook,
                        resumeBook,
                        genereBook,
                        score,
                        publicatioDate
                    )
                }

            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_overflow,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_sing_out -> goToLoginActivity()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun goToLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
*/
    }
}