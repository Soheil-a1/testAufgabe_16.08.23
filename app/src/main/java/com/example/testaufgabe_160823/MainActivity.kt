package com.example.testaufgabe_160823

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testaufgabe_160823.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCheck.setOnClickListener {binding.editTextInput.editText?.text.toString()
            val input = binding.editTextInput.editText?.text.toString()
            val arr = input.split(",").map { it.trim() }

            val intArr = mutableListOf<Int>()
            var isValidInput = true
            for (item in arr) {
                try {
                    val number = item.toInt()
                    intArr.add(number)
                } catch (e: NumberFormatException) {
                    isValidInput = false
                    break
                }
            }

            if (isValidInput) {
                val result = istUnunterbrocheneZahlen(intArr.toIntArray())
                val message = if (result) "Die Zahlenfolge ist ununterbrochen." else "Die Zahlenfolge ist nicht ununterbrochen."
                binding.tvErgebis.text = message
            } else {
                Snackbar.make(binding.btnCheck, "Ungültige Eingabe", Snackbar.LENGTH_SHORT).show()
            }

        }
    }




    private fun istUnunterbrocheneZahlen(arr: IntArray): Boolean {
        val sortiertesArr = arr.sorted()
        for (i in 0 until sortiertesArr.size - 1) {
            if (sortiertesArr[i] + 1 != sortiertesArr[i + 1]) {
                return false
            }
        }
        return true
    }



}












