package com.example.midtern_q3



import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SpinnerActivity : AppCompatActivity() {

    private lateinit var spinnerOptions: Spinner
    private lateinit var buttonSubmit: Button
    private lateinit var textViewResult: TextView
    private var selectedOption: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)

        spinnerOptions = findViewById(R.id.spinnerOptions)
        buttonSubmit = findViewById(R.id.buttonSubmit)
        textViewResult = findViewById(R.id.textViewResult)

        // Set up the spinner
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.options_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerOptions.adapter = adapter
        }

        spinnerOptions.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                selectedOption = parent.getItemAtPosition(position) as String
                textViewResult.text = getString(R.string.selected_option, selectedOption)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                selectedOption = null
                textViewResult.text = getString(R.string.nothing_selected)
            }
        }

        buttonSubmit.setOnClickListener {
            if (selectedOption != null) {
                Toast.makeText(this, getString(R.string.submitted_option, selectedOption), Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, getString(R.string.select_option), Toast.LENGTH_SHORT).show()
            }
        }
    }
}
