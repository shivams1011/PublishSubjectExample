package com.beuni.publishsubjectexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class CarsListingFragment : Fragment() {

    lateinit var adapter: CarsAdapter
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = CarsAdapter()
        recyclerData.apply {
            layoutManager = LinearLayoutManager(activity)
        }

        recyclerData.adapter = adapter
        adapter.updateListItem(getListOfItem())

        setObserver()
    }

    private fun setObserver() {
        adapter.getPublishSubject().subscribe(
            this::onItemClick
        )
    }

    fun onItemClick(value: String): Unit {
        Toast.makeText(activity,value, Toast.LENGTH_SHORT).show()
    }

    private fun getListOfItem(): MutableList<String> {
        val items = mutableListOf<String>()
        items.add("Lamborghini")
        items.add("Porsche")
        items.add("Maserati")
        items.add("Bugatti")
        items.add("Aston Martin")
        return items
    }
}
