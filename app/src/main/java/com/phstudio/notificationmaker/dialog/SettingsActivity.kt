package com.phstudio.notificationmaker.dialog

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.phstudio.notificationmaker.R

class SettingsActivity : Activity() {

    @SuppressLint("CommitPrefEdits")
    fun settings(context: Context) {
        val editor = context.getSharedPreferences(
            context.resources.getString(R.string.app_package),
            Context.MODE_PRIVATE
        ).edit()

        val inflater = LayoutInflater.from(context)
        val dialogView = inflater.inflate(R.layout.layout_settings, null)
        val customDialog = AlertDialog.Builder(context)
            .setView(dialogView)
            .show()

        val select_timer = dialogView.findViewById<Spinner>(R.id.select_timer)
        val list3 = ArrayList<String>()
        list3.add(context.resources.getString(R.string.timeclock))
        list3.add(context.resources.getString(R.string.hour12))
        list3.add(context.resources.getString(R.string.hour24))
        val adapter3 = ArrayAdapter(context, R.layout.layout_spinner, list3)
        adapter3.setDropDownViewResource(R.layout.layout_spinner)
        select_timer.adapter = adapter3
        select_timer.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long,
            ) {
                when (position) {
                    0 -> {
                    }
                    1 -> {
                        editor.putString("TimeFormat", "10PM")
                        editor.apply()
                        Toast.makeText(
                            context,
                            context.resources.getString(R.string.hour12set),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    2 -> {
                        editor.putString("TimeFormat", "22:00")
                        editor.apply()
                        Toast.makeText(
                            context, context.resources.getString(R.string.hour24set),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
        val fb_back = dialogView.findViewById<FloatingActionButton>(R.id.fb_back)
        fb_back.setOnClickListener {
            customDialog.dismiss()
        }
    }
}