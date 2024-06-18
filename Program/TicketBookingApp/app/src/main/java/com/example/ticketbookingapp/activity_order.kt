package com.example.ticketbookingapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class activity_order : AppCompatActivity() {

    private lateinit var sharedPreferencesHelper: SharedPreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        sharedPreferencesHelper = SharedPreferencesHelper(this)

        val etName = findViewById<EditText>(R.id.etName)
        val etDate = findViewById<EditText>(R.id.etDate)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            val name = etName.text.toString()
            val date = etDate.text.toString()

            if (name.isNotEmpty() && date.isNotEmpty()) {
                // Simulasi penyimpanan data tiket
                val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                val dateParsed = sdf.parse(date)
                val calendar = Calendar.getInstance()
                calendar.time = dateParsed!!
                calendar.add(Calendar.DAY_OF_YEAR, 7)
                val validUntil = sdf.format(calendar.time)

                sharedPreferencesHelper.saveTicket(name, date, validUntil)

                Toast.makeText(this, "Tiket berhasil dipesan", Toast.LENGTH_SHORT).show()

                // Kembali ke MainActivity
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Harap isi semua field", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
