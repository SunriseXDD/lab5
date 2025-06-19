package com.example.lab5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val hoursInput = findViewById<EditText>(R.id.hoursInput)
        val discountSeekBar = findViewById<SeekBar>(R.id.discountSeekBar)
        val discountText = findViewById<TextView>(R.id.discountText)
        val calculateButton = findViewById<Button>(R.id.calculateButton)

        discountSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                discountText.text = "Скидка: $progress%"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        calculateButton.setOnClickListener {
            val hours = hoursInput.text.toString().toIntOrNull() ?: 0
            val discount = discountSeekBar.progress

            Intent(this, ResultActivity::class.java).apply {
                putExtra("HOURS", hours)
                putExtra("DISCOUNT", discount)
                startActivity(this)
            }
        }
    }
}