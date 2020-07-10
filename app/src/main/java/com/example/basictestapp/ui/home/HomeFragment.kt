package com.example.basictestapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.basictestapp.R
import com.example.basictestapp.storage.StoreRetrieveData

class HomeFragment : Fragment() {

    companion object {
        val FILENAME = "todoitems.json"
    }
    private lateinit var homeViewModel: HomeViewModel
    private var storeRetrieveData: StoreRetrieveData? = null


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        storeRetrieveData = context?.let { StoreRetrieveData(it, FILENAME) }

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
