package com.example.elearningsesi5

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


import android.app.DatePickerDialog
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var btnShowDate: Button
    private lateinit var tvSelectedDate: TextView
    private lateinit var btnShowToast: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowDate = findViewById(R.id.btnShowDate)
        tvSelectedDate = findViewById(R.id.tvSelectedDate)
        btnShowToast = findViewById(R.id.btnShowToast)

        btnShowDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePicker = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
                val date = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                tvSelectedDate.text = "Tanggal dipilih: $date"
            }, year, month, day)

            datePicker.show()
        }

        btnShowToast.setOnClickListener {
            Toast.makeText(this, "!", Toast.LENGTH_SHORT).show()
        }
    }
}
