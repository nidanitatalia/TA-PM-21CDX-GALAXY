package com.example.ticketbookingapp

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesHelper(context: Context) {

    private val preferences: SharedPreferences = context.getSharedPreferences("ticketPrefs", Context.MODE_PRIVATE)

    fun saveTicket(name: String, date: String, validUntil: String) {
        val editor = preferences.edit()
        editor.putString("name", name)
        editor.putString("date", date)
        editor.putString("validUntil", validUntil)
        editor.apply()
    }

    fun getTicketDetails(): String {
        val name = preferences.getString("name", "N/A")
        val date = preferences.getString("date", "N/A")
        val validUntil = preferences.getString("validUntil", "N/A")
        return "Nama: $name\nTanggal: $date\nBerlaku hingga: $validUntil"
    }

    fun clearTicket() {
        val editor = preferences.edit()
        editor.clear()
        editor.apply()
    }
}
