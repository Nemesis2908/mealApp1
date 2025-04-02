package com.usaid.mealapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.findViewTreeViewModelStoreOwner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //code start here
        //declaring the variables
        val timeOfDay = findViewById<EditText>(R.id.timeOfDay)
        val tvOutput = findViewById<TextView>(R.id.displaySuggestion)
        val btnFindMeal = findViewById<Button>(R.id.findMealButton)
        val btnReset = findViewById<Button>(R.id.resetButton)

        //Reset button to clear user input and the meal suggestions
        btnReset.setOnClickListener {
            timeOfDay.text.clear()
            tvOutput.text = " "
            timeOfDay.hint = "Example- Breakfast, Mid-Morning, Afternoon, Mid-Afternoon, Dinner, Late Night"
        }
        // check if the user input matches with the time of day
        btnFindMeal.setOnClickListener{
            var timeDay = timeOfDay.text.toString().trim()

            if (timeDay == "Breakfast") {
                tvOutput.text = "Breakfast Options: \nEggs \nPorridge \nWaffels"

            } else if (timeDay == "Mid-Morning") {
                tvOutput.text = "Mid-Morning Options: \nEnergy bar \nSandwich \nPie"

            } else if (timeDay == "Afternoon") {
                tvOutput.text = "Afternoon Options: \nFish and chips \nPizza \nBurger"

            } else if (timeDay == "Mid-Afternoon") {
                tvOutput.text = "Mid-Afternoon Options: \nFruit \nBiscuit \nChocolate"

            } else if (timeDay == "Dinner") {
                tvOutput.text = "Dinner Options: \nPasta \nSteak \nStir Fry"

            } else if (timeDay == "Late Night") {
                tvOutput.text = "Late Night Options: \nIce-cream \nCake \nBrownie"

            } else {
                tvOutput.text = "Please enter a time of day"
            }
            }
            }//end of code


}
