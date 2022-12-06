package com.example.wyjazd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import androidx.core.view.get
import kotlin.time.Duration.Companion.days

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data_przyjazdu = findViewById<Button>(R.id.start)
        val data_wyjazdu = findViewById<Button>(R.id.stop)
        val text = findViewById<TextView>(R.id.dane)
        val kalendarz = findViewById<CalendarView>(R.id.selektor)
        kalendarz.setMinDate(kalendarz.date)

        data_przyjazdu.setOnClickListener {
            var data_przyj = kalendarz.getDate()


        }


    }
}