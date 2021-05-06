package com.example.searchreminders

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    // declare DBHandler as mutable field using null safety
    var dbHandler: DBHandler? = null

    // declare RecyclerView as mutable field using null safety
    var reminderRecyclerView: RecyclerView? = null

    // declare a ReminderAdapter as a mutable field
    // specify that it will be initialized later
    lateinit var reminderAdapter: ReminderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // fully initialize dbHandler
        dbHandler = DBHandler(this, null)

        // make RecyclerView refer to actual RecyclerView in activity_main layout resource
        reminderRecyclerView = findViewById<View>(R.id.reminderRecyclerView) as RecyclerView

        // initialize a MutableList of Reminders
        var reminder: MutableList<Reminder> = ArrayList()

        // initialize the ReminderAdapter
        reminderAdapter = ReminderAdapter(reminder)

        // tell Kotlin that RecyclerView isn't null and set the ReminderAdapter on it
        reminderRecyclerView!!.adapter = reminderAdapter

        // tell Kotlin that the RecylerView isn't null and apply a LinearLayout to it
        reminderRecyclerView!!.layoutManager = LinearLayoutManager(this)

        // populate the Reminder table in the database
        // these lines of code should be commented out after the
        // app is run the first time
        addReminder("High Priority Reminder 1", "High", "2021-05-02")
        addReminder("High Priority Reminder 2", "High", "2021-05-03")
        addReminder("Medium Priority Reminder 1", "Medium", "2021-05-04")
        addReminder("Medium Priority Reminder 2", "Medium", "2021-05-05")
        addReminder("Low Priority Reminder 1", "Low", "2021-05-06")
        addReminder("Low Priority Reminder 2", "Low", "2021-05-07")
    }

    /**
     * This method populates a Reminder in the database.  It gets called when
     * the app launches.
     * @param text Reminder text
     * @param priority Reminder priority
     * @param date Reminder date
     */
    fun addReminder(text: String, priority: String, date: String) {
        dbHandler?.addReminders(text, priority, date)
    }

    /**
     * This method gets called when the Search button is clicked.  It
     * searches for Reminders with low priority and
     * refreshes the ReminderAdapter with the retrieved data so that it
     * may be displayed in the RecyclerView.
     * @param view MainActivity
     */
    fun searchLow(view: View?){
        val priority = "Low"

        // call search by priority in ReminderAdapter
        reminderAdapter.search(dbHandler!!, "priority", priority)
        // refresh ReminderAdapter Mutable List
        reminderAdapter.reminder = dbHandler!!.search("priority", priority)
    }
    /**
     * This method gets called when the Search button is clicked.  It
     * searches for Reminders with medium priority and
     * refreshes the ReminderAdapter with the retrieved data so that it
     * may be displayed in the RecyclerView.
     * @param view MainActivity
     */
    fun searchMedium(view: View?){
        val priority = "Medium"

        // call search by priority in ReminderAdapter
        reminderAdapter.search(dbHandler!!, "priority", priority)
        // refresh ReminderAdapter Mutable List
        reminderAdapter.reminder = dbHandler!!.search("priority", priority)
    }
    /**
     * This method gets called when the Search button is clicked.  It
     * searches for Reminders with high priority and
     * refreshes the ReminderAdapter with the retrieved data so that it
     * may be displayed in the RecyclerView.
     * @param view MainActivity
     */
    fun searchHigh(view: View?){
        val priority = "High"

        // call search by priority in ReminderAdapter
        reminderAdapter.search(dbHandler!!, "priority", priority)
        // refresh ReminderAdapter Mutable List
        reminderAdapter.reminder = dbHandler!!.search("priority", priority)
    }
}