package com.example.mad_105_final_project2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/*********************************************************************************
 * MAD-105 Final Project to get user input on a cup of Tea (ie: similar to Starbucks, but with tea)
 * Author:  Al Jette
 * Date: April-2022
 * Second Screen (MainActivity2) collects details on the cup of tea
 *
 * First Screen Variables passed to MainActivity2
 *   customerName => the customer name
 *   customerPhone => the customer's phone
 *
 * Second Screen Variables
 *   idBtnBlackTea (from layout) = teaTypeBlack
 *   idBtnGreenTea (from layout) = teaTypeGreen
 *   idBtnHerbalTea (from layout) = teaTypeHerbal
 *   idToggleSugar (from layout)
 *   idToggleCream (from layout)
 *
 *   idSeekBarSize (from layout) = custSelectTeaSize:  Tea size being ordered 1=small, 2=medium, 3=large
 *   idSeekBarText (from layout) =custSelectTeaSizeText: Displays the tea size selected by the customer
 *   idButtonToScr3 (from layout) = screen3Btn => goes to screen 3 (MainActivity3)
 */

class MainActivity2 : AppCompatActivity() {

    private var customerName: String? = ""
    private var customerPhone: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val displayName: TextView = findViewById(R.id.idPrintName)
        val displayPhone: TextView = findViewById(R.id.idPrintPhone)
        val rbTeaBlack = findViewById<RadioButton>(R.id.idBtnBlackTea)
        val rbTeaGreen = findViewById<RadioButton>(R.id.idBtnGreenTea)
        val rbTeaHerbal = findViewById<RadioButton>(R.id.idBtnHerbalTea)
        val custSelectTeaSize: SeekBar = findViewById(R.id.idSeekBarSize)
        val custSelectTeaSizeText: TextView = findViewById(R.id.idSeekBarText)
        val screen3Btn = findViewById<Button>(R.id.idButtonToScr3)

        val extras = intent.extras
        if (extras != null) {
            customerName = extras.getString("CustName")
            customerPhone = extras.getString("CustPhone")
        }

        displayName.text = customerName
        displayPhone.text = customerPhone

        var custSelectedTeaSize: Int = 2
        var teaType = "None"

        if (rbTeaBlack.isChecked) {
            teaType = "Black"
        } else if (rbTeaGreen.isChecked) {
            teaType = "Green"
        } else if (rbTeaHerbal.isChecked) {
            teaType = "Herbal"
        }

        //  When user moves the Seekbar, retrieve new value and update seekbarOutputText
        custSelectTeaSize.run {

            //  When user moves the Seekbar, retrieve new value and update seekbarOutputText
            setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                    custSelectedTeaSize = p1
                    when (custSelectedTeaSize) {
                        1 -> custSelectTeaSizeText.text = "Small"
                        2 -> custSelectTeaSizeText.text = "Medium"
                        3 -> custSelectTeaSizeText.text = "Large"
                        else -> custSelectTeaSizeText.text = "Out of Bound"
                    }
                }

                override fun onStartTrackingTouch(p0: SeekBar?) {
                    //                     seekbarOutputText.text = "TinyFine"
                }

                override fun onStopTrackingTouch(p0: SeekBar?) {

                }

            })
        }


        screen3Btn.setOnClickListener {
            val nextScreen = Intent(this@MainActivity2, MainActivity3::class.java)
            nextScreen.putExtra("CustName", customerName.toString())
            nextScreen.putExtra("CustPhone", customerPhone.toString())

            startActivity(nextScreen)
        }
    }
}