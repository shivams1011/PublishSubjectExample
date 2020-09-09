package com.beuni.publishsubjectexample

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.layout_item.view.*

class CarsViewHolder(itemView: View, publishSubject: PublishSubject<String>) : RecyclerView.ViewHolder(itemView) {

    var publishSubject: PublishSubject<String>? = null
    init {
         this.publishSubject= publishSubject
    }

    fun bindData(value: String) {
        itemView.txtName.text = value
        itemView.txtName.setOnClickListener {
            publishSubject!!.onNext(value)
        }
    }
}
