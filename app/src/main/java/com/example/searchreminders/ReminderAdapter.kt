package com.example.searchreminders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ReminderAdapter (
    // declare a MutableList of Reminders
    var reminder: MutableList<Reminder>
) : RecyclerView.Adapter<ReminderAdapter.ReminderViewHolder>(){
        // declare a ViewHolder that will hold the layout of an item in
        // the RecyclerView
        class ReminderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

        // declare TextView immutable field using null safety
        var reminderTextView: TextView? = null
        // declare TextView immutable field using null safety
        var dateTextView: TextView? = null

        /**
         * Create a ReminderViewHolder that references the li_main layout resource
         * and return it.
         */
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): ReminderAdapter.ReminderViewHolder {
            return  ReminderViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.li_main,
                    parent,
                    false
                ))
        }

        /**
         * Initialize each of the items in the RecyclerView and map the
         * data in the MutableList of Reminders to it.
         */
        override fun onBindViewHolder(holder: ReminderAdapter.ReminderViewHolder, position: Int) {
            // get current item in MutableList of Reminders and store it in
            // immutable variable
            val currentReminder = reminder[position]

            holder.itemView.apply {
                // make TextView refer to TextView in li_main layout resource
                reminderTextView = findViewById<View>(R.id.reminderTextView) as TextView
                // assign the name value in the current item to text attribute of
                // TextView
                reminderTextView!!.text = currentReminder.reminderText
                // make TextView refer to TextView in li_main layout resource
                dateTextView = findViewById<View>(R.id.dateTextView) as TextView
                // assign the name value in the current item to text attribute of
                // TextView
                dateTextView!!.text = currentReminder.date
            }
        }

        /**
         * Return the number of items in the MutableList of Reminders
         */
        override fun getItemCount(): Int {
            return reminder.size
        }

        /**
         * This method gets called by the search method in the MainActivity
         * when the search button is clicked.  It will call the DBHandler method
         * that searches for Reminders based on the specified search criteria.
         */
        fun search(dbHandler: DBHandler, key: String, value: String) {
            dbHandler?.search(key, value)
            notifyDataSetChanged()
        }
    }