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
import kotlin.math.absoluteValue
import kotlin.time.Duration.Companion.days


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Zamaina daty na właściwy format
        fun konwert(czasowa: Long): List<Int>{
            val date = Date(czasowa)
            val dateFormat = SimpleDateFormat("yyyy/MM/dd")
            val formDate = dateFormat.format(date).split("/").map {
                it.toInt()
            }
            return formDate
        }

        fun policz(lastDay: MutableList<Int>, firstDay : MutableList<Int>, czas_trwania : TextView) {
            val departureDay = (firstDay[0] * 360) + (firstDay[1] * 30) + firstDay[2]
            val backDay = (lastDay[0] * 360) + (lastDay[1] * 30) + lastDay[2]
            val diff = departureDay.toChar() - backDay.toChar()
            czas_trwania.text = " ${System.lineSeparator()}${diff.absoluteValue + 1}"
        }



        //Zmienne
        val data_przyjazdu = findViewById<Button>(R.id.start)
        val data_wyjazdu = findViewById<Button>(R.id.stop)
        val czas_trwania = findViewById<TextView>(R.id.dane)
        val kalendarz = findViewById<CalendarView>(R.id.selektor)
        val wyj_text = findViewById<TextView>(R.id.wyjazd)
        val przyj_text = findViewById<TextView>(R.id.przyjazd)
        val firstDay = mutableListOf(0,0,0)
        val lastDay = mutableListOf(0,0,0)
        val selDate = arrayListOf(konwert(kalendarz.date)[0] ,konwert(kalendarz.date)[1] ,konwert(kalendarz.date)[2])

        //Ustawianie blokad
        kalendarz.setMinDate(kalendarz.date)
        kalendarz.maxDate = Date().time + 631138519

        //Lista
        kalendarz.setOnDateChangeListener{ _, d, m, y ->
            selDate[0] = d
            selDate[1] = m+1
            selDate[2] = y
        }

        data_przyjazdu.setOnClickListener {
            if (lastDay[0] <= selDate[0] || lastDay[1] <= selDate[1] || lastDay[2] <= selDate[2]) for (i in 0 until 3)
                firstDay[i] = selDate[i]
            przyj_text.text =  "${System.lineSeparator()}${firstDay[0]}-${firstDay[1]}-${firstDay[2]}"
        }

        data_wyjazdu.setOnClickListener {
            for (i in 0 until 3)
                lastDay[i] = selDate[i]
            wyj_text.text = "${System.lineSeparator()}${lastDay[0]}-${lastDay[1]}-${lastDay[2]}"
        }

        if(firstDay[2] > lastDay[2] && firstDay[1] == lastDay[1]){
            przyj_text.text = wyj_text.text
            wyj_text.text = przyj_text.text
        }

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



    }


