package com.jamshidbek.foodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jamshidbek.foodapp.adapter.MyAdapter
import com.jamshidbek.foodapp.utils.MySharedPreference
import kotlinx.android.synthetic.main.activity_list_food.*

class ListFoodActivity : AppCompatActivity() {

    lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_food)
        title = "Barcha taomlar"

        MySharedPreference.init(this)
        val list = MySharedPreference.objectString
        myAdapter = MyAdapter(this, list)
        list_food.adapter = myAdapter


        list_food.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, AboutFoodActivity::class.java)
            intent.putExtra("position", position)
            startActivity(intent)
        }
    }
}