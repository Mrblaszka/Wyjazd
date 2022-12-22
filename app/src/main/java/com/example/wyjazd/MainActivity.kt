package com.example.wyjazd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.Date
import kotlin.math.absoluteValue


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Zamaina daty na właściwy format
        fun konwert(czasowa: Long): List<Int>{
            val date = Date(czasowa)
            val dateFormat = SimpleDateFormat("dd/MM/yyyy")
            val formDate = dateFormat.format(date).split("/").map {
                it.toInt()
            }
            return formDate
        }

        //Wyliczanie dni
        fun rezerwacja(koniec: MutableList<Int>, poczatek : MutableList<Int>, czas_trwania : TextView) {
            val wyjazd = (poczatek[2] * 360) + (poczatek[1] * 30) + poczatek[0]
            val przyjazd = (koniec[2] * 360) + (koniec[1] * 30) + koniec[0]
            val ilosc_dni = wyjazd.toChar() - przyjazd.toChar()
            czas_trwania.text = " ${System.lineSeparator()}${ilosc_dni.absoluteValue + 1}"
        }

        //Podmiana daty
        fun podmiana(koniec: MutableList<Int>, poczatek : MutableList<Int>, przyj_text : TextView, wyj_text : TextView) {
            if(poczatek[0] > koniec[0]){
                        for (i in 0 until 3) {
                            poczatek[i]
                        }
                przyj_text.text = wyj_text.text
                wyj_text.text = "${System.lineSeparator()}${poczatek[0]}-${poczatek[1]}-${poczatek[2]}"
            }
            else if(poczatek[0] == koniec[0]){
                if(poczatek[1] > koniec[1]){
                    for (i in 0 until 3) {
                        poczatek[i]
                    }
                    przyj_text.text = wyj_text.text
                    wyj_text.text = "${System.lineSeparator()}${poczatek[0]}-${poczatek[1]}-${poczatek[2]}"
                }
                else if(poczatek[1] == koniec[1]){
                    if(poczatek[2] > koniec[2]){
                        for (i in 0 until 3) {
                            poczatek[i]
                        }
                        przyj_text.text = wyj_text.text
                        wyj_text.text = "${System.lineSeparator()}${poczatek[0]}-${poczatek[1]}-${poczatek[2]}"
                    }
                }
            }
        }








        //Zmienne
        val data_przyjazdu = findViewById<Button>(R.id.start)
        val data_wyjazdu = findViewById<Button>(R.id.stop)
        val czas_trwania = findViewById<TextView>(R.id.dane)
        val kalendarz = findViewById<CalendarView>(R.id.selektor)
        val wyj_text = findViewById<TextView>(R.id.wyjazd)
        val przyj_text = findViewById<TextView>(R.id.przyjazd)
        val poczatek = mutableListOf(0,0,0)
        val koniec = mutableListOf(0,0,0)
        val data = arrayListOf(konwert(kalendarz.date)[0] ,konwert(kalendarz.date)[1] ,konwert(kalendarz.date)[2])
        val rezerwuj = findViewById<Button>(R.id.rezerwacja)

        //Ustawianie blokad
        kalendarz.minDate = Date().time
        kalendarz.maxDate = Date().time + 63115200000


        //Lista
        kalendarz.setOnDateChangeListener{_, d, m, y ->
            data[0] = y
            data[1] = m+1
            data[2] = d
        }

        //Przyciski

        rezerwuj.setOnClickListener{
            podmiana(koniec,poczatek,przyj_text,wyj_text)
            rezerwacja(poczatek, koniec, czas_trwania)
        }
        data_przyjazdu.setOnClickListener {
             for (i in 0 until 3)
                poczatek[i] = data[i]
            przyj_text.text =  "${System.lineSeparator()}${poczatek[0]}-${poczatek[1]}-${poczatek[2]}"
        }

        data_wyjazdu.setOnClickListener {
            for (i in 0 until 3)
                koniec[i] = data[i]
            wyj_text.text = "${System.lineSeparator()}${koniec[0]}-${koniec[1]}-${koniec[2]}"
        }






    }
}




