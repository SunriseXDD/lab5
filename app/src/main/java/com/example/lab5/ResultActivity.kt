package com.example.lab5

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity

class ResultActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        val hours = intent.getIntExtra("HOURS", 0)
        val discount = intent.getIntExtra("DISCOUNT", 0)

        val pricePerHour = 2000
        var total = hours * pricePerHour

        if (discount > 0) {
            total = (total * (100 - discount) / 100)
        }

        resultTextView.text = "Оплатить = $total рублей\n(Скидка $discount%)"
    }
}