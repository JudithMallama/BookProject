package com.example.bookproject.ui.newbook

import android.app.DatePickerDialog
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.bookproject.databinding.FragmentNewBookBinding
import com.example.bookproject.model.Book
import java.text.SimpleDateFormat
import java.util.*

class NewBookFragment : Fragment() {

    private lateinit var newBookBinding: FragmentNewBookBinding
    private lateinit var viewModel: NewBookViewModel
    private var cal = Calendar.getInstance()
    private var publicatioDate = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        newBookBinding = FragmentNewBookBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[NewBookViewModel::class.java]
        return newBookBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dateSetListener = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, month)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val format = "dd/MM/yyyy"
            val simpleDateFormat = SimpleDateFormat(format, Locale.US)
            publicatioDate = simpleDateFormat.format(cal.time).toString()
            newBookBinding.publicationDateButton.text = publicatioDate
        }
        with(newBookBinding) {

            publicationDateButton.setOnClickListener {
                DatePickerDialog(
                    requireContext(),
                    dateSetListener,
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)
                ).show()
            }
            newBookBinding.saveButton.setOnClickListener() {

                if (nameBookEditText.text?.isEmpty() == true ||
                    nameAutorEditText.text?.isEmpty() == true ||
                    pagesEditText.text?.isEmpty() == true
                ) {
                    Toast.makeText(
                        requireContext(),
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

                    val book = Book(
                        name= nameBook,
                        author=autorBook,
                        pages=pagesBook,
                        abstract=resumeBook,
                        genere=genereBook,
                        score=score,
                        publicationDate=publicatioDate
                    )
                    findNavController().navigate(NewBookFragmentDirections.actionNewBookFragmentToDatailFragment(book))


                }


            }

        }


    }

}