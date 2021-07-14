package com.jamshidbek.foodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.jamshidbek.foodapp.models.Food
import com.jamshidbek.foodapp.utils.MySharedPreference
import kotlinx.android.synthetic.main.activity_add_food.*

class AddFoodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_food)

        MySharedPreference.init(this)

        btn_save.setOnClickListener {
            val name = edt_food_name.text.toString().trim()
            val products = edt_food_products.text.toString().trim()
            val preparationOrder = edt_preparation_order.text.toString().trim()

            if (name!="" && products!="" && preparationOrder!=""){
                val list = MySharedPreference.objectString
                list.add(Food(name, products, preparationOrder))
                MySharedPreference.objectString = list
                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
                finish()
            }else{
                Toast.makeText(this, "Not enough information", Toast.LENGTH_SHORT).show()
            }
        }
    }
}