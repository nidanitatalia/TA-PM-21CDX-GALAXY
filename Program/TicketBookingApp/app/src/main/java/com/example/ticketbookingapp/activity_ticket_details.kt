package com.example.ticketbookingapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class activity_ticket_details : AppCompatActivity() {

    private lateinit var sharedPreferencesHelper: SharedPreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ticket_details)

        sharedPreferencesHelper = SharedPreferencesHelper(this)

        val tvTicketDetails = findViewById<TextView>(R.id.tvTicketDetails)
        val btnCancelTicket = findViewById<Button>(R.id.btnCancelTicket)

        // Ambil detail tiket dari SharedPreferences
        val ticketDetails = sharedPreferencesHelper.getTicketDetails()
        tvTicketDetails.text = ticketDetails

        btnCancelTicket.setOnClickListener {
            // Simulasi pembatalan tiket dan proses pengembalian dana
            sharedPreferencesHelper.clearTicket()
            Toast.makeText(this, "Tiket dibatalkan dan pengembalian dana diproses", Toast.LENGTH_SHORT).show()

            // Kembali ke MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
