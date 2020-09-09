package com.beuni.publishsubjectexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.subjects.PublishSubject

class CarsAdapter: RecyclerView.Adapter<CarsViewHolder>() {

    private val publishSubject = PublishSubject.create<String>()
    private var listOfCars = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarsViewHolder {
       return CarsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent, false), publishSubject)
    }

    override fun onBindViewHolder(holder: CarsViewHolder, position: Int) {
        holder.bindData(listOfCars[position]);
    }

    override fun getItemCount(): Int {
        return listOfCars.size
    }

    fun updateListItem(listOfCars: MutableList<String>) {
        this.listOfCars = listOfCars
        notifyDataSetChanged()
    }

    fun getPublishSubject(): PublishSubject<String> {
        return publishSubject
    }

}