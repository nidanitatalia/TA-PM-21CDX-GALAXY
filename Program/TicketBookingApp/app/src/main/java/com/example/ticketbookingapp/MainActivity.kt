package com.example.ticketbookingapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnOrderTicket = findViewById<Button>(R.id.btnOrderTicket)
        val btnViewTicket = findViewById<Button>(R.id.btnViewTicket)

        btnOrderTicket.setOnClickListener {
            val intent = Intent(this, activity_order::class.java)
            startActivity(intent)
        }

        btnViewTicket.setOnClickListener {
            val intent = Intent(this, activity_ticket_details::class.java)
            startActivity(intent)
        }
    }
}

