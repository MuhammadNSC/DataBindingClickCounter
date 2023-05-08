package com.example.databindingclickcounter

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.databindingclickcounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // layout using DataBindingUtil
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Set initial counter value to 0
        binding.textViewCounter.text = counter.toString()

        // Set click listeners for buttons
        binding.btnIncrement.setOnClickListener { incrementCounter() }
        binding.btnDecrement.setOnClickListener { decrementCounter() }
        binding.btnReset.setOnClickListener { resetCounter() }
    }

    private fun incrementCounter() {
        val prevValue = counter
        counter++
        binding.textViewCounter.text = counter.toString()
        val toastMessage = "Increment: $prevValue -> $counter"
        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
    }

    private fun decrementCounter() {
        val prevValue = counter
        counter--
        binding.textViewCounter.text = counter.toString()
        val toastMessage = "Decrement: $prevValue -> $counter"
        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
    }

    private fun resetCounter() {
        val prevValue = counter
        counter = 0
        binding.textViewCounter.text = counter.toString()
        val toastMessage = "Reset: $prevValue -> $counter"
        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
    }
}