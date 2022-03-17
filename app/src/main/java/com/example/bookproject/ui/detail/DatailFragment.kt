package com.example.bookproject.ui.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.bookproject.databinding.FragmentDatailBinding

class DatailFragment : Fragment() {

    private lateinit var detailBinding: FragmentDatailBinding
    private lateinit var detailviewModel: DatailViewModel
    private val args: DatailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{

        detailBinding = FragmentDatailBinding.inflate(inflater,container,false)
        detailviewModel = ViewModelProvider(this)[DatailViewModel::class.java]
        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val book = args.book

        with(detailBinding){
            nameBookTextView.text= book.name
            authorTextView.text = book.author


        }
    }



}