package com.example.wyjazd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import androidx.core.view.get
import java.text.SimpleDateFormat
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
            var milisekundy = data_przyj
                val date = milisekundy
                val formattedDateAsDigitMonth = SimpleDateFormat("dd/MM/yyyy")
                text.text = "Data przyjazdu" + formattedDateAsDigitMonth.format(date) +"\n"
        }
        data_wyjazdu.setOnClickListener {
            var data_wyj = kalendarz.getDate()
            var milisekundy = data_wyj
            val date = milisekundy
            val formattedDateAsDigitMonth = SimpleDateFormat("dd/MM/yyyy")
            text.text = text.text.toString() +  "Data wyjazdu" + formattedDateAsDigitMonth.format(date) +"\n"
        }
    }
}