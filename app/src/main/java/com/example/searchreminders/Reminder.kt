package com.example.searchreminders

/**
 * The Reminder data class has four fields that map to the
 * columns in the Reminder table in the database.  It will be used
 * to exchange data between the database and the RecylerView.
 */
data class Reminder(
    // declare an immutable Int to store the reminder id
    val id: Int,
    // declare an immutable String to store the Reminder name
    val reminderText: String,
    // declare an immutable String to store the Reminder major
    val priority: String,
    // declare an immutable String to store the Reminder major
    val date: String
)