package com.example.wyjazd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import androidx.core.view.get
import java.text.SimpleDateFormat
import java.util.Date
import kotlin.time.Duration.Companion.days


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data_przyjazdu = findViewById<Button>(R.id.start)
        val data_wyjazdu = findViewById<Button>(R.id.stop)
        val text = findViewById<TextView>(R.id.dane)
        val kalendarz = findViewById<CalendarView>(R.id.selektor)
        val wyj_text = findViewById<TextView>(R.id.wyjazd)
        val przyj_text = findViewById<TextView>(R.id.przyjazd)
        kalendarz.setMinDate(kalendarz.date)
        kalendarz.maxDate = Date().time + 63072000000



        data_przyjazdu.setOnClickListener {
            var data_przyj = kalendarz.getDate()
            var milisekundy = data_przyj
                val date = milisekundy
                val formattedDateAsDigitMonth = SimpleDateFormat("dd/MM/yyyy")
                przyj_text.text =  formattedDateAsDigitMonth.format(date)
        }
        data_wyjazdu.setOnClickListener {
            var data_wyj = kalendarz.getDate()
            var milisekundy = data_wyj
            val date = milisekundy
            val formattedDateAsDigitMonth = SimpleDateFormat("dd/MM/yyyy")
            wyj_text.text = formattedDateAsDigitMonth.format(date)
        }
    }

    private fun zmienNaDate(czasowa: Long): Any {
            val date = Date(czasowa)
            val dateFormat = SimpleDateFormat("yyyy/MM/dd")
            val formDate = dateFormat.format(date).split("/").map {
                it.toInt()
        }
            return date
    }
}
