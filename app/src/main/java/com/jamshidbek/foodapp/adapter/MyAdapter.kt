package com.jamshidbek.foodapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.jamshidbek.foodapp.R
import com.jamshidbek.foodapp.models.Food
import kotlinx.android.synthetic.main.activity_about_food.view.*
import kotlinx.android.synthetic.main.food_item.view.*

class MyAdapter(context: Context, val list:List<Food>):ArrayAdapter<Food>(context, R.layout.food_item, list) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val itemView:View
        if (convertView == null) {
            itemView = LayoutInflater.from(parent.context).inflate(R.layout.food_item, parent, false)
        }else{
            itemView = convertView
        }
        itemView.txt_name1.text = list[position].name

        return itemView
    }
}