package com.example.midtern_q3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CalculatorActivity : AppCompatActivity() {

    private lateinit var editTextNumber1: EditText
    private lateinit var editTextNumber2: EditText
    private lateinit var buttonAdd: Button
    private lateinit var buttonSubtract: Button
    private lateinit var buttonMultiply: Button
    private lateinit var buttonDivide: Button
    private lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        editTextNumber1 = findViewById(R.id.editTextNumber1)
        editTextNumber2 = findViewById(R.id.editTextNumber2)
        buttonAdd = findViewById(R.id.buttonAdd)
        buttonSubtract = findViewById(R.id.buttonSubtract)
        buttonMultiply = findViewById(R.id.buttonMultiply)
        buttonDivide = findViewById(R.id.buttonDivide)
        textViewResult = findViewById(R.id.textViewResult)

        buttonAdd.setOnClickListener { calculate("add") }
        buttonSubtract.setOnClickListener { calculate("subtract") }
        buttonMultiply.setOnClickListener { calculate("multiply") }
        buttonDivide.setOnClickListener { calculate("divide") }
    }

    private fun calculate(operation: String) {
        val num1String = editTextNumber1.text.toString()
        val num2String = editTextNumber2.text.toString()

        if (num1String.isEmpty() || num2String.isEmpty()) {
            Toast.makeText(this, getString(R.string.enter_both_numbers), Toast.LENGTH_SHORT).show()
            return
        }

        val num1 = num1String.toDoubleOrNull()
        val num2 = num2String.toDoubleOrNull()

        if (num1 == null || num2 == null) {
            Toast.makeText(this, getString(R.string.invalid_number), Toast.LENGTH_SHORT).show()
            return
        }

        val result = when (operation) {
            "add" -> num1 + num2
            "subtract" -> num1 - num2
            "multiply" -> num1 * num2
            "divide" -> if (num2 != 0.0) num1 / num2 else {
                Toast.makeText(this, getString(R.string.cannot_divide_by_zero), Toast.LENGTH_SHORT).show()
                return
            }
            else -> 0.0
        }

        textViewResult.text = result.toString()
    }
}
